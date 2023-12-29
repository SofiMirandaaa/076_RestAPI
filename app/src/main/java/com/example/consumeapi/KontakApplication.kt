package com.example.consumeapi

import android.app.Application
import com.example.consumeapi.repository.AppContainer
import com.example.consumeapi.repository.KontakContainer

class KontakApplication : Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = KontakContainer()
    }
}