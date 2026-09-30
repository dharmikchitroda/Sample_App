package com.example.sample_app.ui.theme.Fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.media.Image
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.sample_app.R
import com.example.sample_app.ui.theme.viewmodels.MiniAppViewmodel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.io.File

val Context.userDataStore by preferencesDataStore(name = "user_prefs")
class ProfileFragment : Fragment(R.layout.fragment_profile) {

    val viewmodel: MiniAppViewmodel by activityViewModels()

    val NAME_KEY = stringPreferencesKey("user_name")

    suspend fun saveName(name: String) {
        requireContext().userDataStore.edit { preferences ->
            preferences[NAME_KEY] = name
        }
    }

    suspend fun getName(): String {
        val prefs =  requireContext().userDataStore.data.first()
        return prefs[NAME_KEY] ?: "No name saved"
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profileImageView = view.findViewById<ImageView>(R.id.ivProfileImage)
        val pencilicon = view.findViewById<ImageView>(R.id.ivProfilebtn)
        val editbtn = view.findViewById<Button>(R.id.btnEditProfile)
        val nameTextView = view.findViewById<TextView>(R.id.tvProfileName)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {

                viewmodel.LocaleUri.collect { uri ->
                    if (uri != null) {
                        profileImageView.setImageURI(uri)
                    } else {
                        profileImageView.setImageResource(R.drawable.userimg)
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            val name = getName()
            nameTextView.text = name
        }

        val ActivityResult = registerForActivityResult(
            ActivityResultContracts.PickVisualMedia()
        ) { Imguri ->

            if (Imguri != null) {

            /*
                val bitmap = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
                                    ImageDecoder.decodeBitmap(
                                        ImageDecoder.createSource(requireContext().contentResolver, Imguri)
                                    )
                            } else MediaStore.Images.Media.getBitmap(requireContext().contentResolver, Imguri)
            */
                viewmodel.saveImgUri(requireContext(), Imguri)

            } else {
                Log.d("Bitmap_image", "User cancelled — no image selected")
            }
        }

        pencilicon.setOnClickListener {

            ActivityResult.launch(
                PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
            )
        }

        editbtn.setOnClickListener {

            val editText = EditText(requireContext()).apply {
                hint = "Enter your name"
                setText(nameTextView.text)
            }

            AlertDialog.Builder(requireContext())
                .setTitle("Edit Name")
                .setView(editText)
                .setPositiveButton("Save") { _, _ ->
                    val newName = editText.text.toString().trim()
                    if (newName.isNotEmpty())  {
                        lifecycleScope.launch {
                            saveName(newName)
                            nameTextView.text = newName
                        }
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
            Build.VERSION_CODES.S
        }
    }
}
/*  */