package com.bachir.sportsnewsandinformationapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.models.Event

class EventsRecyclerViewAdapter(private var listOfEvents : MutableList<Event>) :
    RecyclerView.Adapter<EventsRecyclerViewAdapter.MyHolder>()
{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EventsRecyclerViewAdapter.MyHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.event_item,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: EventsRecyclerViewAdapter.MyHolder, position: Int) {
     val currentItem = listOfEvents[position]
        holder.itemView.findViewById<TextView>(R.id.tvEventName).text = currentItem.name
        holder.itemView.findViewById<TextView>(R.id.tvEventDescription).text = currentItem.description
        holder.itemView.findViewById<TextView>(R.id.tvEventDate).text = currentItem.date.toString()

    }

    override fun getItemCount(): Int {
        return listOfEvents.size

    }

    fun addEvent(event: Event) {
        listOfEvents.add(event)
        notifyItemChanged(listOfEvents.size - 1)
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}