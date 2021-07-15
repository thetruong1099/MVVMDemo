package com.example.mvvmdemo.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.database.repository.BookRepository
import com.example.mvvmdemo.model.Book
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class BookViewModel(application: Application) : ViewModel() {

    private val bookRepository: BookRepository = BookRepository(application)

    fun insertBook(book: Book) = viewModelScope.launch {
        bookRepository.insertBook(book)
    }

    fun updateBook(book: Book) = viewModelScope.launch {
        bookRepository.updateBook(book)
    }

    fun deleteBook(book: Book) = viewModelScope.launch {
        bookRepository.deleteBook(book)
    }

    fun getAllBook(): LiveData<List<Book>> = bookRepository.getAllBook()

    class BookViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(BookViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return BookViewModel(application) as T
            }

            throw IllegalArgumentException("unable construct viewModel")
        }

    }

}