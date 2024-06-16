package com.example.notesapp

import android.app.Application
import com.example.notesapp.utils.SharedPreference

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        val sharedPreference= SharedPreference()
        sharedPreference.unit(this)

    }
}