package com.example.mvvmdemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmdemo.database.dao.BookDAO
import com.example.mvvmdemo.model.Book

@Database(entities = [Book::class], version = 1)
abstract class BookDatabase : RoomDatabase() {

    abstract fun getBookDao(): BookDAO

    companion object {
        @Volatile
        private var instance: BookDatabase? = null

        fun getInstance(context: Context): BookDatabase {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context, BookDatabase::class.java, "NoteDataBase").build()
            }
            return instance!!
        }
    }
}