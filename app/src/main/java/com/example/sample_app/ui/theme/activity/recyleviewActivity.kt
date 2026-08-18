package com.example.sample_app.ui.theme.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sample_app.databinding.ActivityRecyleviewBinding
import com.example.sample_app.ui.theme.activity_infostudent
import com.example.sample_app.ui.theme.adapter
import com.example.sample_app.ui.theme.`interface`.cardclickinterface
import com.example.sample_app.ui.theme.model.Studentdata
import com.example.sample_app.ui.theme.utils.IntentKeys
import com.example.sample_app.ui.theme.viewmodels.recylerviewviewmodel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class recyleviewActivity : ComponentActivity(), cardclickinterface {

    private lateinit var binding: ActivityRecyleviewBinding
    private val viewModel: recylerviewviewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRecyleviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recview.layoutManager = LinearLayoutManager(this)

        viewModel.loading.observe(this) { isLoading ->
            binding.progressBar.visibility =
                if (isLoading) View.VISIBLE else View.GONE
        }

        val adapter = adapter(emptyList(), this)
        binding.recview.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.studentdatalive.collect { studentlist ->
                    adapter.updateList(studentlist)
                }
            }
        }
    }

    override fun onStudentClick(student: Studentdata) {
        val intent = Intent(this, activity_infostudent::class.java)
        intent.putExtra(IntentKeys.student_name, student.name)
        intent.putExtra(IntentKeys.student_email, student.email)
        intent.putExtra(IntentKeys.student_mobile, student.mobile)
        startActivity(intent)
    }
}