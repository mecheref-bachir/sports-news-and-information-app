package com.bachir.sportsnewsandinformationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.adapters.NewsRecyclerViewAdapter
import com.bachir.sportsnewsandinformationapp.models.News
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton


class NewsFragment : Fragment() {

    private lateinit var rvNews :RecyclerView
    private lateinit var adapter: NewsRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNews = view.findViewById(R.id.rvNews)
        val layoutManager = GridLayoutManager(context,1)
        rvNews.layoutManager=layoutManager
        rvNews.setHasFixedSize(false)
        adapter = NewsRecyclerViewAdapter(Data.ListOfNews)
        rvNews.adapter = adapter
    }

    fun addNews(news: News) {
        adapter.addNews(news)
    }

}