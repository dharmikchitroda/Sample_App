package com.example.sample_app

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PreferenceManager @Inject constructor(@ApplicationContext context: Context) {

    val sharedPreferences = context.getSharedPreferences(
        "Sample_App",
        Context.MODE_PRIVATE
    )

    fun saveinprefernce(key: String, value: String) {
        sharedPreferences.edit()
            .putString(key, value)
            .apply()
    }

}