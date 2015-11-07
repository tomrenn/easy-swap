package com.tomrenn.swap

import android.app.Application
import timber.log.Timber

/**
 *
 */
class SwapApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}