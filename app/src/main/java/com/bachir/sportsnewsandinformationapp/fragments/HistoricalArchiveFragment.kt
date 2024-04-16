package com.bachir.sportsnewsandinformationapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.adapters.ArchivesRecyclerViewAdapter
import com.bachir.sportsnewsandinformationapp.models.Archive
import com.bachir.sportsnewsandinformationapp.sampledata.Data

class HistoricalArchiveFragment : Fragment() {
private lateinit var rvArchive : RecyclerView
private lateinit var adapter: ArchivesRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_historical_archive, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvArchive = view.findViewById(R.id.rvArchive)
        rvArchive.setHasFixedSize(false)
        adapter= ArchivesRecyclerViewAdapter(Data.listOfArchives)
        val layoutManager = GridLayoutManager(context,1)
        rvArchive.layoutManager = layoutManager
        rvArchive.adapter = adapter
    }

    fun addArchive(archive: Archive) {
        adapter.addArchive(archive)
    }


}