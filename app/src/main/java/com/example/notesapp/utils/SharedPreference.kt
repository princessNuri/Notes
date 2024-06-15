package com.example.notesapp.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPreference {

    private lateinit var sharedPreferences: SharedPreferences

    fun unit(context: Context){
        sharedPreferences=context.getSharedPreferences("shared",Context.MODE_PRIVATE)
    }

    var title: String?
    get() = sharedPreferences.getString("title","")
    set(value) = sharedPreferences.edit().putString("title",value)!!.apply()

    var isBoard: Boolean
    get() = sharedPreferences.getBoolean("board",false)
    set(value) = sharedPreferences.edit().putBoolean("board",value).apply()

}