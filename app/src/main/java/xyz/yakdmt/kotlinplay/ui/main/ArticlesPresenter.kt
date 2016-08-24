package xyz.yakdmt.kotlinplay.ui.main

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import xyz.yakdmt.kotlinplay.MyApplication
import xyz.yakdmt.kotlinplay.model.Repository
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by yakdmt on 17/08/16.
 */
class ArticlesPresenter : MvpBasePresenter<ArticlesView>() {

    @Inject
    lateinit var repository: Repository

    @field:[Inject Named("somethingElse")]
    lateinit var somethingElse: String

    init {
        MyApplication.graph.inject(this)
    }

    fun loadArticles(pullToRefresh: Boolean) {

       view!!.setData(repository.getArticles())

    }

}