package xyz.yakdmt.kotlinplay.network

import com.google.gson.*
import xyz.yakdmt.kotlinplay.model.Article
import java.lang.reflect.Type

/**
 * Created by yakdmt on 25/08/16.
 */
class ArticleDeserializer : JsonDeserializer<List<Article>> {

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): List<Article> {

        val gson = Gson()
        val jsonResponse = json.asJsonObject.getAsJsonObject("response") ?: return listOf()
        val jsonDocs = jsonResponse.getAsJsonArray("docs") ?: return listOf()
        val result : MutableList<Article> = mutableListOf()
        for (jsonArticle in jsonDocs) {
            val article = gson.fromJson(jsonArticle, Article::class.java)
            if (article!=null){
                result.add(article)
            }
         }

        try {
            //article = gson.fromJson(json, Article::class.java)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listOf(Article("test","test"))
    }
}