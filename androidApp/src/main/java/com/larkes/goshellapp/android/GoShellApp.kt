package com.larkes.goshellapp.android

import android.app.Application
import platform.PlatformConfiguration

class GoShellApp:Application() {

    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(configuration = PlatformConfiguration(applicationContext))
    }

}