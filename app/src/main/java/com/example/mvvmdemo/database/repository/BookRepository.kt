package com.example.mvvmdemo.database.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmdemo.database.BookDatabase
import com.example.mvvmdemo.database.dao.BookDAO
import com.example.mvvmdemo.model.Book

class BookRepository(app: Application) {

    private val bookDao: BookDAO

    init {
        val noteDataBase: BookDatabase = BookDatabase.getInstance(app)
        bookDao = noteDataBase.getBookDao()
    }

    suspend fun insertBook(book: Book) = bookDao.insertBook(book)
    suspend fun updateBook(book: Book) = bookDao.updateBook(book)
    suspend fun deleteBook(book: Book) = bookDao.deleteBook(book)
    fun getAllBook(): LiveData<List<Book>> = bookDao.getAllBook()


}