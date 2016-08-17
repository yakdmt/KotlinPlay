package xyz.yakdmt.kotlinplay.ui.main

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import xyz.yakdmt.kotlinplay.R

/**
 * Created by yakdmt on 17/08/16.
 */
class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var image: ImageView? = null
    var name: TextView? = null

    init {
        image = view.findViewById(R.id.image) as ImageView
        name = view.findViewById(R.id.title) as TextView
    }

}