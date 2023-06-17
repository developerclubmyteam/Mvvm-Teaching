package com.rajnish.presonalstudy.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajnish.presonalstudy.R
import com.rajnish.presonalstudy.repository.db.Article
import com.squareup.picasso.Picasso

class NewsAdapter (val context:Context, private val article:List<Article>):RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>(){
    class ArticleViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
        var newsImage = itemView.findViewById<ImageView>(R.id.ImgThumbnail)
        var newsTitle = itemView.findViewById<TextView>(R.id.tv_heading)
        var newsDescription = itemView.findViewById<TextView>(R.id.tv_paragraph)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       val  view = LayoutInflater.from(context).inflate(R.layout.news_layout,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return article.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       val article = article[position]
        holder.newsDescription.text = article.description
        holder.newsTitle.text = article.title
       Picasso.get().load(article.urlToImage).into(holder.newsImage)
    }
}