    package com.example.sample_app.ui.theme.reposetry

    import android.content.Context
    import com.example.sample_app.ui.theme.LocalData.Room.AppDatabase
    import com.example.sample_app.ui.theme.LocalData.Room.MyEntity

    class StudentRepository(context: Context) {

        private val dao = AppDatabase.getdata(context).dao()

        suspend fun insert(student: MyEntity) {
            dao.insert(student)
        }
    }