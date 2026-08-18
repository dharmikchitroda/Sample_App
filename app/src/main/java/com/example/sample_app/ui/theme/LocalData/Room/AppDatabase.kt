package com.example.sample_app.ui.theme.LocalData.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MyEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): MyDao


    companion object {

        private var database: AppDatabase? = null

        fun getdata(context: Context): AppDatabase {

            if (database == null) {

                database =
                    Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "student_db"
                    ).build()
            }
            return database!!

        }
    }
}