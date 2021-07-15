package com.example.mvvmdemo.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.Book
import com.example.mvvmdemo.view.adapter.BookAdapter
import com.example.mvvmdemo.viewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bookViewModel: BookViewModel by lazy {
        ViewModelProvider(
            this,
            BookViewModel.BookViewModelFactory(this.application)
        )[BookViewModel::class.java]
    }

    private val bookAdapter: BookAdapter by lazy {
        BookAdapter(onItemClick, onItemDelete)
    }

    private val onItemClick: (Book) -> Unit = { book ->
        val intent = Intent(this, UpdateBookActivity::class.java)
        intent.putExtra("Book Intent", book)
        startActivity(intent)
    }
    private val onItemDelete: (Book) -> Unit = { book ->
        bookViewModel.deleteBook(book)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentToAddBookACtivity()

        setRecyclerViewBook()
    }

    private fun intentToAddBookACtivity() {
        fab_add_book.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setRecyclerViewBook() {
        rv_book.apply {
            adapter = bookAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        bookViewModel.getAllBook().observe(this) {
            bookAdapter.setBookList(it)
        }
    }
}