package com.shuchenysh.mycryptoapp.di

import androidx.lifecycle.ViewModel
import com.shuchenysh.mycryptoapp.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModuleKey(MainViewModel::class)
    fun bindCoinViewModel(viewModel: MainViewModel): ViewModel
}