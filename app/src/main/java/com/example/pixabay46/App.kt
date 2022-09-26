package com.example.pixabay46

import android.app.Application

class App : Application() {

    companion object {
        lateinit var api: PixaApi
    }

    override fun onCreate() {
        super.onCreate()
        api = RetrofitService().getApi()
    }
}