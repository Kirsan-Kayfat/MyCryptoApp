package com.shuchenysh.mycryptoapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.shuchenysh.mycryptoapp.data.repository.CoinRepositoryImpl
import com.shuchenysh.mycryptoapp.domain.GetCoinInfoListUseCase
import com.shuchenysh.mycryptoapp.domain.GetCoinInfoUseCase
import com.shuchenysh.mycryptoapp.domain.LoadDataUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = CoinRepositoryImpl(application)

    private val getCoinInfoUseCase = GetCoinInfoUseCase(repository)
    private val getCoinInfoListUseCase = GetCoinInfoListUseCase(repository)
    private val loadDataUseCase = LoadDataUseCase(repository)

    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }
}