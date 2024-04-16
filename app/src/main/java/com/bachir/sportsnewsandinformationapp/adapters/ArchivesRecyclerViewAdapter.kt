package com.bachir.sportsnewsandinformationapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.models.Archive

class ArchivesRecyclerViewAdapter (private var listOfArchives : MutableList<Archive>):
    RecyclerView.Adapter<ArchivesRecyclerViewAdapter.MyViewHolder>() {
        companion object{
            const val TAG = "ArchivesRecyclerViewAdapter"
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.archive_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = listOfArchives[position]
        holder.itemView.findViewById<TextView>(R.id.tvArchiveName).text = currentItem.historyName
        holder.itemView.findViewById<TextView>(R.id.tvArchiveDate).text = currentItem.date.toString()
        holder.itemView.findViewById<TextView>(R.id.tvArchiveDescription).text = currentItem.description
    }

    override fun getItemCount(): Int {
        Log.i(TAG, "size of archive list ${listOfArchives.size}")
       return listOfArchives.size
    }

    fun addArchive(archive: Archive) {
        listOfArchives.add(archive)
        notifyItemChanged(listOfArchives.size - 1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
