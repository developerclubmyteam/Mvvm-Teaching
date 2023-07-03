package com.rajnish.presonalstudy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajnish.presonalstudy.R
import com.rajnish.presonalstudy.db.News
import com.squareup.picasso.Picasso

class NewsAdapter(private val newsList: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.bind(news)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        private val imageview: ImageView = itemView.findViewById(R.id.imgview)


        fun bind(news: News) {
            titleTextView.text = news.title
            descriptionTextView.text = news.discription
            Picasso.get().load(news.imgUri).into(imageview)

        }
    }
}
