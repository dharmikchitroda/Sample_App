package com.example.sample_app.utils

import android.content.Context
import android.net.Uri
import java.io.File

fun saveImageToInternalStorage(context: Context, uri: Uri): String? {
    return try {
        val inputStream = context.contentResolver.openInputStream(uri)

        // Delete previous profile images to free space
        context.filesDir.listFiles()?.forEach { file ->
            if (file.name.startsWith("profile_image")) {
                file.delete()
            }
        }

        val fileName = "profile_image_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)

        inputStream?.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        file.absolutePath

    } catch (e: Exception) {
        e.printStackTrace()
        null
    }
}
