package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import android.util.Patterns
import androidx.activity.ComponentActivity
import com.example.sample_app.databinding.ActivityCollectionBinding
import com.example.sample_app.ui.theme.model.Studentdata2

class CollectionActivity : ComponentActivity() {

    lateinit var binding: ActivityCollectionBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityCollectionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 1
        val studentslist = listOf(
            Studentdata2("dharmik", "dharmik@gmail.com", "98989898", 10),
            Studentdata2("raj", "raj@gmail.com", "98765432", 72),
            Studentdata2("priya", "priya@gmail.com", "91234567", 88),
            Studentdata2("amit", "amit@gmail.com", "99887766", 45),
            Studentdata2("neha", "neha@gmail.com", "98761234", 95),
            Studentdata2("rohan", "rohan@gmail.com", "90123456", 63),
            Studentdata2("jay", "vinod@gmail.com", "98991234", 80),
            Studentdata2("dhruv", "vinod@gmail.com", "97654321", 76),
            Studentdata2("meera", "meera@gmail.com", "91239876", 84),
            Studentdata2("yash", "yash@gmail.com", "99881234", 100)
        )

        var abs = Studentdata2("dharmik", "dharmik@gmail.com", "98989898", 10)
        var abs2 = Studentdata2("dharmik", "dharmik@gmail.com", "98989898", 10)

        var dataclass =  abs.abc

        binding.tvResult.text = dataclass.toString()


//        val result = studentslist.filter { it.mark > 70 }.sortedByDescending { it.mark }.map {  it.name to it.mark }
//        binding.tvResult.text = result.toString()


        /*  Task 2: Duplicate & Group Handling	*/

//        val Set = studentslist.toSet()
//        val sameail = Set.groupBy { it.email }.filter { it.value.size > 1 }.keys
//        binding.tvResult.text = sameail.toString()

        /*  Task 3: Advanced Search & Validation  */

//        val result = studentslist.find { it.email.equals("vinod@gmail.com") }
//        val result = studentslist.any { it.mark < 50} // return boolean
//        val result = studentslist.all { it.mark > 50 }
//        val result = studentslist.all {
//            Patterns.EMAIL_ADDRESS.matcher(it.email).matches()
//        }

        /*  Task 4: Student Ranking System	*/
        val pass = studentslist.filter { it.mark >= 35 }.map { it.name }
        val fail = studentslist.filter { it.mark < 35 }.map { it.name }
        val rank = studentslist.filter { it.mark > 35 }.sortedByDescending { it.mark }
            .map { it.name to it.mark }
        val lowtohigh = studentslist.sortedBy { it.mark }.map { it.name to it.mark }

//        binding.tvResult.text = lowtohigh.toString()

    }

    /* Task 1: Student Data Analysis	*/
    private fun studentAnalysis(students: List<Studentdata2>) {
        val result = students
            .filter { it.mark > 70 }
            .sortedByDescending { it.mark }
            .map { it.name to it.mark }

//        binding.tvResult.text = result.toString()



    }

}

