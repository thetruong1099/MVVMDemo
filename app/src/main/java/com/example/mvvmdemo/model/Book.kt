package com.example.mvvmdemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "book_table")
data class Book(
    @ColumnInfo(name = "name_col") var name: String = "",
    @ColumnInfo(name = "author_col") var author: String = ""
) : Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id_col")
    var id: Int = 0
}