package com.shuchenysh.mycryptoapp.domain

class LoadDataUseCase(private val repository: CoinRepository) {

    suspend operator fun invoke() = repository.loadData()

}