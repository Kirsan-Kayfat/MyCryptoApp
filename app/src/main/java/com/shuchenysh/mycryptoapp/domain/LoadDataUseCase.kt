package com.shuchenysh.mycryptoapp.domain

class LoadDataUseCase(private val repository: CoinRepository) {

    operator fun invoke() = repository.loadData()

}