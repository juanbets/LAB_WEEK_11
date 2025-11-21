package com.example.lab_week_11_a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Kita cuma pasang layout supaya file ini compile.
        // App yang dipakai sebenarnya adalah MainActivity di lab_week_11_b.
        setContentView(R.layout.activity_main)
    }
}
