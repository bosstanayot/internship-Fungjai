package fungjai.intern.bosstanayot.internfungjaikotlin.serviceTest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class RestServiceTestHelper {
    @Throws(Exception::class)
    fun <T> createRetrofitService(host: String, classTarget: Class<T>): T {
        val client = OkHttpClient.Builder().build()
        return Retrofit.Builder()
                .client(client)
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(classTarget)
    }
}