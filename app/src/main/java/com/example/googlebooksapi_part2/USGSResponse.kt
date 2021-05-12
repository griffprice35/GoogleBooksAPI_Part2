package com.example.googlebooksapi_part2

import com.squareup.moshi.Json

class USGSResponse {
    @Json(name = "items")
    lateinit var bookItemsList: List<BookItems>
}

class BookItems {
    @Json(name = "selfLink")
    lateinit var bookSelfLink: String

    @Json(name = "volumeInfo")
    lateinit var bookVolumeInfo: BookVolumeInfo
}

class BookVolumeInfo {
    @Json(name = "title")
    lateinit var bookTitle: String

    @Json(name = "subtitle")
    lateinit var bookSubtitle: String

    @Json(name = "authors")
    lateinit var bookAuthorsList: List<BookAuthors>
}

class BookAuthors {
    lateinit var bookAuthors: String
}