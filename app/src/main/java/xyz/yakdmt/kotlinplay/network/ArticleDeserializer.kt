package xyz.yakdmt.kotlinplay.network

import android.util.Log
import com.google.gson.*
import xyz.yakdmt.kotlinplay.model.Article
import java.lang.reflect.Type

/**
 * Created by yakdmt on 25/08/16.
 */
class ArticleDeserializer : JsonDeserializer<Article> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Article {
        Log.d("Test/Deserializer", "Using a custom deserializer for Login WS")

        val gson = Gson()
        var article : Article
        try {
            article = gson.fromJson(json, Article::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return Article("test","test")
    }
}