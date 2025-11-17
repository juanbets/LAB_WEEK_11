package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PreferenceViewModel(
    private val preferenceWrapper: PreferenceWrapper
) : ViewModel() {

    // Simpan teks ke SharedPreferences lewat wrapper
    fun saveText(text: String) {
        preferenceWrapper.saveText(text)
    }

    // Ambil teks sebagai LiveData biar bisa di-observe Activity
    fun getText(): LiveData<String> {
        return preferenceWrapper.getText()
    }
}
