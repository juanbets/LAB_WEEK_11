package com.example.lab_week_11_b

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import java.io.File

class FileHelper(private val context: Context) {

    // Generate a URI to access the file (pakai FileProvider)
    // URI ini sifatnya sementara, akses dibatasi ke app lain
    fun getUriFromFile(file: File): Uri {
        return FileProvider.getUriForFile(
            context,
            "com.example.lab_week_11_b.camera", // harus sama dengan authorities di Manifest
            file
        )
    }

    // Folder untuk gambar (Pictures)
    fun getPicturesFolder(): String =
        Environment.DIRECTORY_PICTURES

    // Folder untuk video (Movies)
    fun getVideosFolder(): String =
        Environment.DIRECTORY_MOVIES
}
