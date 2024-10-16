package com.shuchenysh.mycryptoapp.di

import android.app.Application
import com.shuchenysh.mycryptoapp.presentation.CoinApp
import com.shuchenysh.mycryptoapp.presentation.CoinDetailFragment
import com.shuchenysh.mycryptoapp.presentation.MainActivity
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
        WorkerModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: CoinDetailFragment)

    fun inject(application: CoinApp)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}