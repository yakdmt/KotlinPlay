package xyz.yakdmt.kotlinplay.ui.main

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState
import xyz.yakdmt.kotlinplay.MyApplication
import xyz.yakdmt.kotlinplay.R
import xyz.yakdmt.kotlinplay.model.Article

class ArticlesActivity : ArticlesView, MvpLceViewStateActivity<SwipeRefreshLayout, List<Article>, ArticlesView, ArticlesPresenter>(), SwipeRefreshLayout.OnRefreshListener  {


    var adapter: ArticlesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.graph.inject(this)
        assert(contentView != null)
        retainInstance = true
        contentView.setOnRefreshListener(this)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        adapter = ArticlesAdapter(this, LayoutInflater.from(this))
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //val id = item.itemId

        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }


    override fun setData(data: List<Article>?) {
        adapter?.items = data
        adapter?.notifyDataSetChanged()
    }

    override fun loadData(pullToRefresh: Boolean) {
        presenter.loadArticles(pullToRefresh)
    }

    override fun getErrorMessage(e: Throwable?, pullToRefresh: Boolean): String {
        if (pullToRefresh) return "Error"
        else return "Error while loading. Click here to retry."
    }

    override fun createPresenter(): ArticlesPresenter {
        return ArticlesPresenter()
    }

    override fun createViewState(): LceViewState<List<Article>, ArticlesView> {
        return RetainingLceViewState()
    }

    override fun getData(): List<Article> {
        return adapter?.items!!
    }

    override fun onRefresh() {
        loadData(true)
    }
}

