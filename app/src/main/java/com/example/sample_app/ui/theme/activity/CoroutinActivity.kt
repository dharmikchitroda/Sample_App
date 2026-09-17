package com.example.sample_app.ui.theme.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.sample_app.databinding.ActivityCoroutinBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CoroutinActivity : AppCompatActivity() {
    lateinit var bindng: ActivityCoroutinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindng = ActivityCoroutinBinding.inflate(layoutInflater)

        setContentView(bindng.root)

        //Task 1 : Start a Coroutine

        /*   bindng.btnstart.setOnClickListener {

           lifecycleScope.launch(Dispatchers.Main) {

               bindng.tvStatus.text = "Task is started"

               //    Thread.sleep(2000)
               delay(5000)

               bindng.tvStatus.text = "Task is done"
           }

        } */

        // Task 2: Suspend + Dispatchers
        /*   bindng.btnstart.setOnClickListener {

           lifecycleScope.launch(Dispatchers.Main) {

               bindng.tvStatus.text = "Loading"

               val result = getData()

               bindng.tvStatus.text = result

           }
        } */

        // Task 3: Launch vs Async
        bindng.btnstart.setOnClickListener {

            lifecycleScope.launch(Dispatchers.Main) {

                bindng.tvStatus.text = "Loading"

        // 1-> Async
                /*   val name = async { getUserName() }
                 val mail = async { getUserEmail() }


                 val finalname = name.await()  // here not next line move and run block that wait to the respons
                 val finalmail = mail.await() */

        // 2-> Launch
                   var finalname = "no"
                   var finalmail = "no"

                /*    launch { finalname = getUserName() }  //this will not retun any thing ex": take 3 so move next
                   launch { finalmail = getUserEmail() }  // this take 3 so move next

                  // move here and print no becuse now still suspend ruunng both  lunch
                  bindng.tvStatus.text = "Name: $finalname,\nEmail: $finalmail"
                 */

            // 2.1-> USING join solve above problem
                // this solve using join() if join me please wait

                val job1 = launch { finalname = getUserName() }
                val job2 = launch { finalmail = getUserEmail() }

                job1.join()   // is coroutine wait till work
                job2.join()   // isse bhi wait karo

                bindng.tvStatus.text = "Name: $finalname,\nEmail: $finalmail"

            }

        }
    }

    suspend fun getData(): String {

        delay(5000)
        return "Data Loaded"

    }

    suspend fun getUserName(): String {
        delay(3000)
        return "Dharmik"

    }

    suspend fun getUserEmail(): String {

        delay(3000)
        return "Dharmik@gmail.com"

    }


}

