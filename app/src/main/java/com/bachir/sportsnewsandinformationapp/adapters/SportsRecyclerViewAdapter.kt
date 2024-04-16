package com.bachir.sportsnewsandinformationapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.models.Sport

class SportsRecyclerViewAdapter(
    private var listOfSports: MutableList<Sport>,
    private val addingSport: AddSport
) : RecyclerView.Adapter<SportsRecyclerViewAdapter.MyViewHolder>() {
    fun interface AddSport {
        fun addSport()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SportsRecyclerViewAdapter.MyViewHolder {
        val viewItem =
            LayoutInflater.from(parent.context).inflate(R.layout.sport_item, parent, false)
        return MyViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: SportsRecyclerViewAdapter.MyViewHolder, position: Int) {

        val currentItem = listOfSports[position]
        holder.itemView.findViewById<TextView>(R.id.tvSportType).text = currentItem.type.typeName
        holder.itemView.findViewById<TextView>(R.id.tvSportName).text = currentItem.sportName
        holder.itemView.findViewById<TextView>(R.id.tvInstruction).text = currentItem.instruction
        addingSport.addSport()

    }

    override fun getItemCount(): Int {
        return listOfSports.size
    }

    fun addSport(sport: Sport) {
        listOfSports.add(sport)
        notifyItemChanged(listOfSports.size - 1)
    }


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}