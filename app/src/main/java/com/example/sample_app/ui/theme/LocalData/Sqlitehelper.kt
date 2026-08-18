package com.example.sample_app.ui.theme.LocalData

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Sqlitehelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    /* we can direct pass in prm but this is very best to pass prm , dont direct write varible pass beacuse
       first call above class after make varible so that is not possible , so idea is make a compainion object that
       create together while above parent class call / projct intalized  */

    companion object {
        private const val DB_NAME = "MyAppDB"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "students"
    }

    // this mathod call first time db create
    override fun onCreate(db: SQLiteDatabase?) {

        val query = """ CREATE TABLE $TABLE_NAME ( 
           id INTEGER PRIMARY KEY AUTOINCREMENT,
           name TEXT ,
           age INR )
       """.trimIndent() // extra space remove

        db?.execSQL(query)
    }

    // this method create after change the db version
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val query = " DROP TABLE IF EXISTS $TABLE_NAME "

        db?.execSQL(query)
        onCreate(db)
    }

    // custom function for insert data inside this class easily
    fun insert(name: String, age: String): Boolean {

        val db = this.writableDatabase

        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
        }

        val result =
            db.insert(
                TABLE_NAME,
                null,
                values
            ) //added sucessfully retun base on id like 0L,1L here L=long
        return result != -1L
    }

    fun getallstudent(): List<String> {

        val list = mutableListOf<String>()
        val db = this.writableDatabase

        // return cursor = point to the raw , initial phase not point to the any raw
        val cursor: Cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        // dont use while that entire in infitelopp
        if (cursor.moveToFirst()) {
            do {
        //      val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val age = cursor.getInt(2)

                list.add("ID : $id, Name :$name , Age : $age")
            } while (cursor.moveToNext())
        }

        cursor.close()
        return list
    }

    // get using id
    fun getStudentById(id: Int): String? {
        val db = this.writableDatabase

//  " SELECT * FROM students WHERE id = ?"  -  ? = placehoder  actual --  selectionArgs: Array<String>?
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME WHERE id = ?", arrayOf(id.toString()))

        var result: String? = null

        if (cursor.moveToFirst()) {
            val studentId = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val age = cursor.getInt(cursor.getColumnIndexOrThrow("age"))
            result = "ID: $studentId, Name: $name, Age: $age"
        }
        cursor.close()
        return result
    }
}