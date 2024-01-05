package com.bestswlkh0310.clean_home.application

import android.content.Context
import android.content.SharedPreferences
import java.util.UUID

class PreferenceManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences(CLEAN_HOME_APP, Context.MODE_PRIVATE)

    var id: String by PreferenceDelegate(ID, "")


    fun deleteAllToken() {
        id = ""
    }

    companion object {
        private const val CLEAN_HOME_APP = "RTR_APP"

        private const val ID = "ID"
    }

    private inner class PreferenceDelegate<T>(
        private val key: String,
        private val defaultValue: T
    ) {
        operator fun getValue(thisRef: Any?, property: Any?): T {
            return when (defaultValue) {
                is String -> prefs.getString(key, defaultValue as String) as T
                is Boolean -> prefs.getBoolean(key, defaultValue as Boolean) as T
                is Int -> prefs.getInt(key, defaultValue as Int) as T
                else -> throw IllegalArgumentException("Unsupported preference type")
            }
        }

        operator fun setValue(thisRef: Any?, property: Any?, value: T) {
            when (value) {
                is String -> prefs.edit().putString(key, value as String).apply()
                is Boolean -> prefs.edit().putBoolean(key, value as Boolean).apply()
                is Int -> prefs.edit().putInt(key, value as Int).apply()
                else -> throw IllegalArgumentException("Unsupported preference type")
            }
        }
    }
}
