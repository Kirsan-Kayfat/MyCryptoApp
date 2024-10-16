package com.shuchenysh.mycryptoapp.data.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.work.ExistingWorkPolicy
import androidx.work.WorkManager
import com.shuchenysh.mycryptoapp.data.database.AppDatabase
import com.shuchenysh.mycryptoapp.data.database.CoinInfoDao
import com.shuchenysh.mycryptoapp.data.mapper.CoinMapper
import com.shuchenysh.mycryptoapp.data.workers.RefreshDataWorker
import com.shuchenysh.mycryptoapp.domain.CoinInfo
import com.shuchenysh.mycryptoapp.domain.CoinRepository
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val application: Application,
    private val mapper: CoinMapper,
    private val coinInfoDao: CoinInfoDao
) : CoinRepository {

   override fun getCoinInfoList(): LiveData<List<CoinInfo>> {
        return coinInfoDao.getPriceList().map {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun getCoinInfo(fromSymbol: String): LiveData<CoinInfo> {
        return coinInfoDao.getPriceInfoAboutCoin(fromSymbol).map {
            mapper.mapDbModelToEntity(it)
        }
    }

    override fun loadData() {
        val workManager = WorkManager.getInstance(application)
        workManager.enqueueUniqueWork(
            RefreshDataWorker.NAME,
            ExistingWorkPolicy.REPLACE,
            RefreshDataWorker.makeRequest()
        )
    }
}