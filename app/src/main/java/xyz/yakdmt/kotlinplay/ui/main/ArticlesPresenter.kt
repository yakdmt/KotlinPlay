package xyz.yakdmt.kotlinplay.ui.main

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.functions.Action1
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
        view!!.showLoading(pullToRefresh)
        repository.requestUpdate(Action1 { result ->
            view!!.setData(result)
            view!!.showContent()
        }, Action1 { error ->
            view!!.showError(error, pullToRefresh)
        })

    }

}