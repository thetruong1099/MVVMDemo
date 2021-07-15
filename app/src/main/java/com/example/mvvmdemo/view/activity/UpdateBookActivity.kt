package com.example.mvvmdemo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.Book
import com.example.mvvmdemo.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_update_book.*

class UpdateBookActivity : AppCompatActivity() {

    private val bookViewModel: BookViewModel by lazy {
        ViewModelProvider(
            this,
            BookViewModel.BookViewModelFactory(this.application)
        )[BookViewModel::class.java]
    }

    private lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_book)

        getDataIntent()

        initListenButton()
    }

    private fun getDataIntent() {
        book = intent.getSerializableExtra("Book Intent") as Book
        edt_name.setText(book.name)
        edt_author.setText(book.author)
    }

    private fun initListenButton() {
        btn_edit_book.setOnClickListener {
            book.name = edt_name.text.toString().trim()
            book.author = edt_author.text.toString().trim()
            bookViewModel.updateBook(book)
            finish()
        }
    }
}