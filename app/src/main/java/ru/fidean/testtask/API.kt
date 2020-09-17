package ru.fidean.testtask

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


private const val BASE_URL = "https://random.api.randomkey.io/v1/"

object RetrofitClient {
    var interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    var client = OkHttpClient.Builder()
        .addInterceptor(interceptor);

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(client.build())
        .build()

    var api: RetrofitApi = retrofit.create(RetrofitApi::class.java)
}

interface RetrofitApi {

    @Headers("auth: 0b314a071678afed46662d0ccc6d886f", "Content-Type: application/json")
    @POST("boolean")
    fun getAnswer(@Body records: Int): Deferred<Answer>

}



