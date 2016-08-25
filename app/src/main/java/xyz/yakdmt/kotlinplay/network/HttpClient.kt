package xyz.yakdmt.kotlinplay.network

import android.util.Log
import com.squareup.okhttp.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

/**
 * Created by yakdmt on 25/08/16.
 */
object HttpClient {

    fun create() : OkHttpClient{
        val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("OkHttp", message) })
        logging.level = HttpLoggingInterceptor.Level.BODY
        val client : OkHttpClient = OkHttpClient()
        client.setConnectTimeout(15, TimeUnit.SECONDS)
        client.setReadTimeout(15, TimeUnit.SECONDS)
        client.setWriteTimeout(15, TimeUnit.SECONDS)
        return client
    }
}