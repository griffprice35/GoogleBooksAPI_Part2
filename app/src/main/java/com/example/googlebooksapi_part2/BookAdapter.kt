package com.example.googlebooksapi_part2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooksapi_part2.databinding.ListItemBinding

class BookAdapter(val bookList: List<Book>) : RecyclerView.Adapter<BookViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.bindBook(book)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}