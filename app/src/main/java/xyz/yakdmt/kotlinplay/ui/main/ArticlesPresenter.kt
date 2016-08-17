package xyz.yakdmt.kotlinplay.ui.main

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import xyz.yakdmt.kotlinplay.model.Article

/**
 * Created by yakdmt on 17/08/16.
 */
class ArticlesPresenter : MvpBasePresenter<ArticlesView>() {

    fun loadArticles(pullToRefresh: Boolean) {

       view!!.setData(listOf<Article>(Article("article1","http://i.imgur.com/DvpvklR.png"),
               Article("article2","http://i.imgur.com/DvpvklR.png")))

    }

}