package com.example.googlebooksapi_part2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.googlebooksapi_part2.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BookViewModel by viewModels()

    var books: List<Book> = listOf(
        Book("Android Beginner", "A Beginners Guide to Android", "Griffin Price"),
        Book("Android Expert","", "Amanda Jones"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val mAdapter = BookAdapter(books)
        binding.recyclerView.adapter = mAdapter
        viewModel.getBooks()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}