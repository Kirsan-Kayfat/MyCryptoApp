package com.shuchenysh.mycryptoapp.di

import android.app.Application
import com.shuchenysh.mycryptoapp.data.database.AppDatabase
import com.shuchenysh.mycryptoapp.data.database.CoinInfoDao
import com.shuchenysh.mycryptoapp.data.network.ApiFactory
import com.shuchenysh.mycryptoapp.data.network.ApiService
import com.shuchenysh.mycryptoapp.data.repository.CoinRepositoryImpl
import com.shuchenysh.mycryptoapp.domain.CoinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindCoinRepository(impl: CoinRepositoryImpl): CoinRepository


    companion object {

        @Provides
        @ApplicationScope
        fun provideCoinInfoDao(application: Application): CoinInfoDao {
            return AppDatabase.getInstance(application).coinPriceInfoDao()
        }

        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService {
            return ApiFactory.apiService
        }



    }

}