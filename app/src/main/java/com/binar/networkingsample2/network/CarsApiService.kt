package com.binar.networkingsample2.network

import com.binar.networkingsample2.model.GetAllCarResponseItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface CarsApiService {
    @GET("admin/car")
    fun getAllCar():Call<List<GetAllCarResponseItem>>
}
object CarsApi{
   const val BASE_URL = "https://rent-cars-api.herokuapp.com/"
    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply { httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY }
        }
    private val client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()
    val instance : CarsApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        retrofit.create(CarsApiService::class.java)
    }

}
