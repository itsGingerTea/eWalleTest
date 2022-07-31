package com.example.ewalle

import android.app.Application
import com.example.ewalle.di.AppComponent
import com.example.ewalle.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().bindsApplication(this).build()
    }

    companion object {
        lateinit var appComponent: AppComponent
    }
}