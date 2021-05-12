package com.example.googlebooksapi_part2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookViewModel : ViewModel() {
    private val _response = MutableLiveData<List<Book>>()
    val response: LiveData<List<Book>>
        get() = _response
    fun getBooks(){
        val request = BookAPI.bookApi.getBooks()
        request.enqueue(object: Callback<USGSResponse> {
            override fun onFailure(call: Call<USGSResponse>, t: Throwable) {
                Log.d("RESPONSE", "Failure: " + t.message)
            }

            override fun onResponse(call: Call<USGSResponse>, response: Response<USGSResponse>) {
                val listOfBooksFetched= mutableListOf<Book>()

                val usgsResponse: USGSResponse? = response.body()
                val bookItemsList = usgsResponse?.bookItemsList ?: listOf()

                for(bookItems in bookItemsList){
                    val bookVolumeInfo = bookItems.bookVolumeInfo

                    val title = bookVolumeInfo.bookTitle
                    val subtitle = bookVolumeInfo.bookSubtitle
                    val authors = bookVolumeInfo.bookAuthorsList
                    val url = bookItems.bookSelfLink

                    val newBook = Book(title, subtitle, authors, url)
                    listOfBooksFetched.add(newBook)
                }

                _response.value = listOfBooksFetched
            }
        })
    }
}