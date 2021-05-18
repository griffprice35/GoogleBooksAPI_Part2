package com.example.googlebooksapi_part2

data class Book(val title: String, val subtitle: String = "", val author: List<String>, val url: String)
