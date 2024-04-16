package com.bachir.sportsnewsandinformationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.adapters.EventsRecyclerViewAdapter
import com.bachir.sportsnewsandinformationapp.models.Event
import com.bachir.sportsnewsandinformationapp.sampledata.Data

class EventsFragment : Fragment() {

private lateinit var rvEvent :RecyclerView
private lateinit var adapter: EventsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_evets, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvEvent = view.findViewById(R.id.rvEvent)
        rvEvent.setHasFixedSize(false)
        val layoutManager = GridLayoutManager(context,1)
        rvEvent.layoutManager = layoutManager
        adapter = EventsRecyclerViewAdapter(Data.listOfEvents)
        rvEvent.adapter = adapter
    }

    fun addEvent(event: Event) {
        adapter.addEvent(event)
    }

}