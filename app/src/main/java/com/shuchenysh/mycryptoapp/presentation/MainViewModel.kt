package com.shuchenysh.mycryptoapp.presentation

import androidx.lifecycle.ViewModel
import com.shuchenysh.mycryptoapp.domain.GetCoinInfoListUseCase
import com.shuchenysh.mycryptoapp.domain.GetCoinInfoUseCase
import com.shuchenysh.mycryptoapp.domain.LoadDataUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getCoinInfoUseCase: GetCoinInfoUseCase,
    private val getCoinInfoListUseCase: GetCoinInfoListUseCase,
    private val loadDataUseCase: LoadDataUseCase
) : ViewModel() {


    val coinInfoList = getCoinInfoListUseCase()

    fun getDetailInfo(fSym: String) = getCoinInfoUseCase(fSym)

    init {
        loadDataUseCase()
    }
}