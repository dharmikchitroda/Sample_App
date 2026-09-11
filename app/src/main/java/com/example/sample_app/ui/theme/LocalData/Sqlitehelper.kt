package com.example.sample_app.ui.theme.LocalData

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqlitehelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    companion object {
        private const val DB_NAME = "MyAppDB"
        private const val DB_VERSION = 2
        private const val TABLE_NAME = "students"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query = """ CREATE TABLE $TABLE_NAME ( 
           id INTEGER PRIMARY KEY AUTOINCREMENT,
           name TEXT,
           email TEXT,
           mobile TEXT,
           address TEXT )
       """.trimIndent()

        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query = " DROP TABLE IF EXISTS $TABLE_NAME "
        db?.execSQL(query)
        onCreate(db)
    }

    fun insert(name: String, email: String, mobile: String = "", address: String = ""): Boolean {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put("name", name)
            put("email", email)
            put("mobile", mobile)
            put("address", address)
        }

        val result = db.insert(TABLE_NAME, null, values)
        return result != -1L
    }

    fun getallstudent(): List<String> {
        val list = mutableListOf<String>()
        val db = this.readableDatabase

        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
                list.add("ID: $id, Name: $name, Email: $email")
            } while (cursor.moveToNext())
        }

        cursor.close()
        return list
    }

    fun getStudentById(id: Int): String? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE id = ?", arrayOf(id.toString()))

        var result: String? = null
        if (cursor.moveToFirst()) {
            val studentId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val email = cursor.getString(cursor.getColumnIndexOrThrow("email"))
            result = "ID: $studentId, Name: $name, Email: $email"
        }
        cursor.close()
        return result
    }
}