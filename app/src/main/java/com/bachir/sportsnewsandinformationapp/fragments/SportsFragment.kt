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
import com.bachir.sportsnewsandinformationapp.adapters.SportsRecyclerViewAdapter
import com.bachir.sportsnewsandinformationapp.models.Sport
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SportsFragment : Fragment() {


    private lateinit var rvSports:RecyclerView
    private lateinit var adapter:SportsRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sports, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSports = view.findViewById(R.id.rvSports)
        val layoutManager = GridLayoutManager(context, 2)
        rvSports.setHasFixedSize(true)
        adapter = SportsRecyclerViewAdapter(Data.ListOfSports,SportsRecyclerViewAdapter.AddSport{

        })
        rvSports.adapter = adapter
        rvSports.layoutManager=layoutManager
    }

    fun addSport(sport: Sport) {
        adapter.addSport(sport)
    }

}