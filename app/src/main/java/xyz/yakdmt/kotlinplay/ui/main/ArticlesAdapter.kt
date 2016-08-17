package xyz.yakdmt.kotlinplay.ui.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import com.squareup.picasso.Picasso
import xyz.yakdmt.kotlinplay.R
import xyz.yakdmt.kotlinplay.model.Article

/**
 * Created by yakdmt on 17/08/16.
 */
class ArticlesAdapter(val context: Context, val inflater: LayoutInflater) : RecyclerView.Adapter<ArticleViewHolder> () {

    var items: List<Article>? = null
    var mOnItemClickListener: AdapterView.OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(inflater.inflate(R.layout.holder_article, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder?, position: Int) {
        val hero = items!!.get(position)

        Picasso.with(context)
                .load(hero.imageUrl)
                .placeholder(android.R.color.holo_green_dark)
                .error(android.R.color.holo_green_light)
                .into(holder?.image)

        holder?.name?.text = hero.name
        holder?.itemView?.setOnClickListener { mOnItemClickListener }
    }

    override fun getItemCount(): Int {
        return when (items) {
            null -> 0
            else -> items!!.size
        }
    }

}