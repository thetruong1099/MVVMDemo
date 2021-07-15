package com.example.mvvmdemo.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mvvmdemo.model.Book

@Dao
interface BookDAO {

    @Insert
    suspend fun insertBook(book: Book)

    @Update
    suspend fun updateBook(book: Book)

    @Delete
    suspend fun deleteBook(book: Book)

    @Query("select * from book_table")
    fun getAllBook(): LiveData<List<Book>>
}