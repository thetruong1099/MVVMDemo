package com.example.mvvmdemo.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.R
import com.example.mvvmdemo.model.Book
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter(
    private val onClick: (Book) -> Unit,
    private val onDelete: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    private var bookList = listOf<Book>()

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(book: Book) {
            itemView.tv_item_name.text = book.name
            itemView.tv_item_author.text = book.author
            itemView.btnDelete.setOnClickListener { onDelete(book) }
            itemView.setOnClickListener { onClick(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.book_item, parent, false)
        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.onBind(bookList[position])
    }

    override fun getItemCount(): Int = bookList.size


    fun setBookList(bookList: List<Book>) {
        this.bookList = bookList
        notifyDataSetChanged()
    }
}