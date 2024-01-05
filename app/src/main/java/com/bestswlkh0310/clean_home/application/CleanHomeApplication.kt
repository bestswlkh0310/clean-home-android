package com.bestswlkh0310.clean_home.application

import android.app.Application
import android.content.Context
import android.preference.PreferenceManager


class CleanHomeApplication : Application() {

    companion object {
        lateinit var prefs: PreferenceManager

        private lateinit var instance: CleanHomeApplication

        fun getContext(): Context {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}