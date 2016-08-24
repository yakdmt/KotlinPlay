package xyz.yakdmt.kotlinplay.model

import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.schedulers.Schedulers
import xyz.yakdmt.kotlinplay.MyApplication
import xyz.yakdmt.kotlinplay.network.NetworkService
import javax.inject.Inject

/**
 * Created by yakdmt on 17/08/16.
 */

class Repository {

    @Inject
    lateinit var networkService: NetworkService

    init {
        MyApplication.graph.inject(this)
    }

    fun requestUpdate(onAction: Action1<in List<Article>>, onError: Action1<Throwable>) : Subscription {
        return networkService.getArticles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onAction, onError)

    }

}