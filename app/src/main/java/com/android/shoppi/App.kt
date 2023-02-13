package com.android.shoppi

import android.app.Application
import com.android.shoppi.util.ShoppiDebugTree
import timber.log.Timber

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) Timber.plant(ShoppiDebugTree())
    }
}