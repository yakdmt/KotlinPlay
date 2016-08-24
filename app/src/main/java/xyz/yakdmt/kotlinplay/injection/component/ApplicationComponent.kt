package xyz.yakdmt.kotlinplay.injection.component

import dagger.Component
import xyz.yakdmt.kotlinplay.MyApplication
import xyz.yakdmt.kotlinplay.injection.modules.AndroidModule
import xyz.yakdmt.kotlinplay.ui.main.ArticlesPresenter
import javax.inject.Singleton

/**
 * Created by yakdmt on 17/08/16.
 */
@Singleton
@Component(modules = arrayOf(AndroidModule::class))
interface ApplicationComponent {

    fun inject(application: MyApplication)

    fun inject(articlesPresenter: ArticlesPresenter)

}
