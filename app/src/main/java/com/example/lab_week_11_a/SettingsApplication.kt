package com.example.lab_week_11_a

import android.app.Application

class SettingsApplication : Application() {

    // SettingsStore yang bakal dipakai global di app
    lateinit var settingsStore: SettingsStore
        private set

    override fun onCreate() {
        super.onCreate()
        // Inisialisasi SettingsStore (DataStore)
        settingsStore = SettingsStore(this)
    }
}
