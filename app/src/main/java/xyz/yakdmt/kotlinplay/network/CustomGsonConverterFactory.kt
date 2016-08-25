package xyz.yakdmt.kotlinplay.network

import com.google.gson.GsonBuilder
import retrofit.GsonConverterFactory
import xyz.yakdmt.kotlinplay.model.Article

/**
 * Created by yakdmt on 25/08/16.
 */
object CustomGsonConverterFactory {

    fun create(): GsonConverterFactory{
        val builder : GsonBuilder = GsonBuilder()
        builder.registerTypeAdapter(Article::class.java, ArticleDeserializer())
        val myGson = builder.create()
        return GsonConverterFactory.create(myGson)
    }
}