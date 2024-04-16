package com.bachir.sportsnewsandinformationapp.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.models.News
import com.bumptech.glide.Glide

class NewsRecyclerViewAdapter(private var listOfItems: MutableList<News>) :
    RecyclerView.Adapter<NewsRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsRecyclerViewAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsRecyclerViewAdapter.MyViewHolder, position: Int) {
     val currentItem = listOfItems[position]
        holder.itemView.findViewById<TextView>(R.id.tvNewsTitle).text = currentItem.title
        holder.itemView.findViewById<TextView>(R.id.tvNewsDescription).text = currentItem.description
        val imageView =   holder.itemView.findViewById<ImageView>(R.id.ivNews)
        val activity = holder.itemView.context as Activity
        Glide.with(activity).load(currentItem.imageUrl).into(imageView)
    }

    override fun getItemCount(): Int {
       return listOfItems.size
    }

    fun addNews(news: News) {
        listOfItems.add(news)
        notifyItemChanged(listOfItems.size - 1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}