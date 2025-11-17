package com.example.lab_week_11_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class SettingsViewModel(
    private val settingsStore: SettingsStore
) : ViewModel() {

    // LiveData buat nge-push text ke UI
    private val _textLiveData = MutableLiveData<String>()
    val textLiveData: LiveData<String> = _textLiveData

    init {
        // Ambil text dari DataStore secara async
        viewModelScope.launch {
            settingsStore.text.collect { value ->
                _textLiveData.value = value
            }
        }
    }

    // Simpan text ke DataStore
    fun saveText(text: String) {
        viewModelScope.launch {
            settingsStore.saveText(text)
        }
    }
}
