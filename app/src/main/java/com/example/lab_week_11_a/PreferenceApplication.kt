package com.example.lab_week_11_a

import android.app.Application
import android.content.Context

class PreferenceApplication : Application() {

    // PreferenceWrapper yang nanti dipakai di seluruh app
    lateinit var preferenceWrapper: PreferenceWrapper
        private set

    override fun onCreate() {
        super.onCreate()

        // Inisialisasi PreferenceWrapper dengan SharedPreferences "prefs"
        preferenceWrapper = PreferenceWrapper(
            getSharedPreferences(
                "prefs",              // nama file: prefs.xml
                Context.MODE_PRIVATE  // hanya app ini yang bisa akses
            )
        )
    }
}
