package com.renditriyadi.schedulerapat.sharedpref

import android.content.Context
import android.content.SharedPreferences

class PreferencesHelper (context: Context){

<<<<<<< HEAD
    private val PREFS_NAME = "login123"
    private val sharedpref: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedpref = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        editor= sharedpref.edit()
    }
=======
    private val prefsName = "login123"
    private val sharedpref: SharedPreferences = context.getSharedPreferences(prefsName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor = sharedpref.edit()

>>>>>>> 8466c677ffddc73fae459ec994b1b8a9c4691845
    fun put(key: String, value: String){
        editor.putString(key, value)
            .apply()
    }

    fun getString(key: String) : String {
        return sharedpref.getString(key, null)?:""
    }

    fun put(key: String, value: Boolean){
        editor.putBoolean(key, value)
            .apply()
    }

    fun getBoolean(key: String) : Boolean{
        return sharedpref.getBoolean(key, false)
    }

    fun clear(){
        editor.clear()
            .apply()
    }

}