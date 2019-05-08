package com.vibe.exatech.utils

import android.content.Context
import android.content.SharedPreferences
import com.vibe.exatech.BuildConfig

object Pref {
    val PREF_FILE = BuildConfig.APPLICATION_ID.replace(".", "_")
    val IS_FIRST_TIME = "Is_First_Time"
    private var sharedPreferences: SharedPreferences? = null

    fun openPref(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE)

    }

    fun getValue(context: Context, key: String, defaultValue: String): String? {
        Pref.openPref(context)
        val result = Pref.sharedPreferences?.getString(key, defaultValue)
        Pref.sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String, value: String) {
        Pref.openPref(context)
        val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
        prefPrivateEditor.putString(key, value)
        prefPrivateEditor.apply()
        Pref.sharedPreferences = null
    }

    fun getValue(context: Context, key: String, defaultValue: Boolean): Boolean {
        Pref.openPref(context)
        val result = Pref.sharedPreferences!!.getBoolean(key, defaultValue)
        Pref.sharedPreferences = null
        return result
    }

    fun setValue(context: Context, key: String, value: Boolean) {
        Pref.openPref(context)
        val prefPrivateEditor: SharedPreferences.Editor = Pref.sharedPreferences!!.edit()
        prefPrivateEditor.putBoolean(key, value)
        prefPrivateEditor.apply()
        Pref.sharedPreferences = null
    }

}