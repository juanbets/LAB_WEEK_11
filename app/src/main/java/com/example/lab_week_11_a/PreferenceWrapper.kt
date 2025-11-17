package com.example.lab_week_11_a

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PreferenceWrapper(private val sharedPreferences: SharedPreferences) {

    // LiveData untuk memberi tahu ViewModel kalau text berubah
    private val textLiveData = MutableLiveData<String>()

    init {
        // Listener untuk perubahan di SharedPreferences
        sharedPreferences.registerOnSharedPreferenceChangeListener { _, key ->
            when (key) {
                KEY_TEXT -> {
                    // Notify ViewModel kalau text berubah
                    textLiveData.postValue(
                        sharedPreferences.getString(KEY_TEXT, "")
                    )
                }
            }
        }
    }

    // Simpan text ke SharedPreferences
    fun saveText(text: String) {
        sharedPreferences.edit()
            .putString(KEY_TEXT, text)
            .apply()
    }

    // Ambil text dari SharedPreferences sebagai LiveData
    fun getText(): LiveData<String> {
        textLiveData.postValue(sharedPreferences.getString(KEY_TEXT, ""))
        return textLiveData
    }

    companion object {
        const val KEY_TEXT = "keyText"
    }
}
