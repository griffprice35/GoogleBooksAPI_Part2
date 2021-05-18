package com.example.googlebooksapi_part2

import android.content.Intent
import android.net.Uri
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.googlebooksapi_part2.databinding.ListItemBinding

class BookViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
    private lateinit var currentBook: Book

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val bookUri = Uri.parse(currentBook.url)
        val websiteIntent = Intent(Intent.ACTION_VIEW, bookUri)
        itemView.context.startActivity(websiteIntent)
    }

    fun bindBook(book: Book) {
        currentBook = book
        binding.bookTitle.text = currentBook.title

        if(currentBook.subtitle == ""){
            binding.bookSubtitle.text = currentBook.author.toString().substring(1, currentBook.author.toString().length-1)
            binding.bookAuthor.text = ""
        }

        else{
            binding.bookSubtitle.text = currentBook.subtitle
            binding.bookAuthor.text = currentBook.author.toString().substring(1, currentBook.author.toString().length-1)
        }
    }
}