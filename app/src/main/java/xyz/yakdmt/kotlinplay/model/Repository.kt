package xyz.yakdmt.kotlinplay.model

/**
 * Created by yakdmt on 17/08/16.
 */

class Repository {

    fun getArticles(): List<Article> {
        return listOf<Article>(Article("article1","http://i.imgur.com/DvpvklR.png"),
                Article("article2","http://i.imgur.com/DvpvklR.png"))
    }
}