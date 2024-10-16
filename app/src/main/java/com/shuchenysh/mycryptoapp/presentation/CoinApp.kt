package com.shuchenysh.mycryptoapp.presentation

import android.app.Application
import androidx.work.Configuration
import com.shuchenysh.mycryptoapp.data.workers.CoinWorkerFactory
import com.shuchenysh.mycryptoapp.di.DaggerApplicationComponent
import javax.inject.Inject

class CoinApp: Application(), Configuration.Provider {

    @Inject
    lateinit var workerFactory: CoinWorkerFactory

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        component.inject(this)
        super.onCreate()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory).build()
}