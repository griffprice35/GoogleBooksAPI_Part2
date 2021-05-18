package com.example.googlebooksapi_part2

import com.squareup.moshi.Json

class GoogleBooksResponse {
    @Json(name = "items")
    lateinit var bookItemsList: List<BookItems>
}

class BookItems {
    @Json(name = "accessInfo")
    lateinit var bookAccessInfo: BookAccessInfo

    @Json(name = "volumeInfo")
    lateinit var bookVolumeInfo: BookVolumeInfo
}

class BookVolumeInfo {
    @Json(name = "title")
    lateinit var bookTitle: String

    @Json(name = "subtitle")
    lateinit var bookSubtitle: String

    @Json(name = "authors")
    lateinit var bookAuthorsList: List<String>
}

class BookAccessInfo {
    @Json(name = "webReaderLink")
    lateinit var bookWebReaderLink: String
}