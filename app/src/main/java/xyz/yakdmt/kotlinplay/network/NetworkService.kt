package xyz.yakdmt.kotlinplay.network

import retrofit.http.GET
import rx.Observable
import xyz.yakdmt.kotlinplay.model.Article

/**
 * Created by yakdmt on 24/08/16.
 */
interface NetworkService {

    @GET("articlesearch.json")
    fun getArticles(): Observable<List<Article>>

    @GET("articlesearch.json")
    fun getArticle(): Observable<Article>

}
