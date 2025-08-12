package com.droid.openchat

import android.app.Application
import com.droid.openchat.di.uiModule
import org.koin.core.context.startKoin

class OpenChatApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(uiModule)
        }
    }
}