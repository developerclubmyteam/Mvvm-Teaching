package com.rajnish.presonalstudy.retrofit

import com.rajnish.presonalstudy.repository.db.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


const val BASE_URL = "https://newsapi.org"
const val API_KEY = "acbf05cb82074db292a102a8dcf3816b"


interface NewsInterFace {

    @GET("v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines(@Query("country") country: String, @Query("page") page: Int): Call<News>

    // http://newsapi.org/v2/top-headlines?apiKey=acbf05cb82074db292a102a8dcf3816b&country=in&page=1

}

object NewService {
    val newsIntence: NewsInterFace

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsIntence = retrofit.create(NewsInterFace::class.java)
    }
}