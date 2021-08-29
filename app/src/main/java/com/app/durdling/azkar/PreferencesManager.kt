package com.app.durdling.azkar

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val PREFS_KEY = "com.app.durdling.azkar"

class PreferencesManager(context: Context) {

    private val prefs: SharedPreferences =
        context.getSharedPreferences(PREFS_KEY, Context.MODE_PRIVATE)

    fun getZekerCounter(position: Int) = prefs.getInt(position.toString(), 0)

    fun setZekerCounter(position: Int, counter: Int) =
        prefs.edit { putInt(position.toString(), counter) }

}