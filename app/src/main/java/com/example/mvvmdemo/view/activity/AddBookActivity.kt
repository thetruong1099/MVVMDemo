package com.example.mvvmdemo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.Book
import com.example.mvvmdemo.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_add_book.*

class AddBookActivity : AppCompatActivity() {

    private val bookViewModel: BookViewModel by lazy {
        ViewModelProvider(
            this,
            BookViewModel.BookViewModelFactory(this.application)
        )[BookViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        insertBook()

    }

    private fun insertBook() {
        btn_add_book.setOnClickListener {
            val book = Book(edt_name.text.toString().trim(), edt_author.text.toString().trim())
            bookViewModel.insertBook(book)
            finish()
        }
    }
}