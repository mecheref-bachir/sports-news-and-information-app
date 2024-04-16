package com.bachir.sportsnewsandinformationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.adapters.AthletesRecyclerViewAdapter
import com.bachir.sportsnewsandinformationapp.models.Athlete
import com.bachir.sportsnewsandinformationapp.sampledata.Data


class AthletesFragment : Fragment() {

    private lateinit var rvAthlete:RecyclerView
    private lateinit var adapter: AthletesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_athletes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvAthlete = view.findViewById(R.id.rvAthletes)
        rvAthlete.setHasFixedSize(false)
        adapter = AthletesRecyclerViewAdapter(Data.listOfAthletes)
        val layoutManager = GridLayoutManager(context,1)
        rvAthlete.layoutManager = layoutManager
        rvAthlete.adapter = adapter
    }

    fun addAthlete(athlete: Athlete) {
        adapter.addAthlete(athlete)
    }


}