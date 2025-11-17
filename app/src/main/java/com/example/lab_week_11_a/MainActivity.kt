package com.example.lab_week_11_a

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ambil SettingsStore dari SettingsApplication
        val preferenceWrapper =
            (application as SettingsApplication).settingsStore

        // Buat ViewModel pakai custom ViewModelProvider.Factory
        val preferenceViewModel = ViewModelProvider(
            this,
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return SettingsViewModel(preferenceWrapper) as T
                }
            }
        )[SettingsViewModel::class.java]

        // Observe LiveData dari DataStore -> update TextView tiap ada perubahan text
        preferenceViewModel.textLiveData.observe(this) { text ->
            findViewById<TextView>(R.id.activity_main_text_view).text = text
        }

        // Klik tombol -> simpan isi EditText ke DataStore via SettingsViewModel
        findViewById<Button>(R.id.activity_main_button).setOnClickListener {
            val inputText = findViewById<EditText>(R.id.activity_main_edit_text)
                .text.toString()
            preferenceViewModel.saveText(inputText)
        }
    }
}
