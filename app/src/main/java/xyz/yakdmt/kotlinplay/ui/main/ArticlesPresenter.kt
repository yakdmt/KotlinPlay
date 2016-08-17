package xyz.yakdmt.kotlinplay.ui.main

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import xyz.yakdmt.kotlinplay.model.Article
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by yakdmt on 17/08/16.
 */
class ArticlesPresenter : MvpBasePresenter<ArticlesView>() {

    @field:[Inject Named("something")]
    lateinit var something: String

    @field:[Inject Named("somethingElse")]
    lateinit var somethingElse: String

    fun loadArticles(pullToRefresh: Boolean) {

       view!!.setData(listOf<Article>(Article("article1","http://i.imgur.com/DvpvklR.png"),
               Article("article2","http://i.imgur.com/DvpvklR.png")))

    }

}