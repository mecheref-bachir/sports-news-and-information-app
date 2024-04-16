package com.bachir.sportsnewsandinformationapp.adapters

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.models.Athlete

class AthletesRecyclerViewAdapter(private var listOfAthletes: MutableList<Athlete>) :
    RecyclerView.Adapter<AthletesRecyclerViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AthletesRecyclerViewAdapter.MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.athletes_item, parent, false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: AthletesRecyclerViewAdapter.MyViewHolder, position: Int) {
        val currentItem = listOfAthletes[position]
        val spannable = SpannableString("Name: ${currentItem.name}")
        spannable.setSpan(StyleSpan(Typeface.BOLD),0,spannable.length,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        holder.itemView.findViewById<TextView>(R.id.tvName).text =spannable
        holder.itemView.findViewById<TextView>(R.id.tvAthleteSportName).text = "Sport: ${currentItem.sportName}"
        holder.itemView.findViewById<TextView>(R.id.tvCountry).text = "Country: ${ currentItem.country }"
        holder.itemView.findViewById<TextView>(R.id.tvBestPerformance).text = "Personal Best: ${currentItem.bestPerformance}"
        holder.itemView.findViewById<TextView>(R.id.tvMedals).text = "Medals: ${currentItem.medals}"
        holder.itemView.findViewById<TextView>(R.id.tvFacts).text = "Facts: ${currentItem.facts}"

    }

    override fun getItemCount(): Int {
        return listOfAthletes.size
    }

    fun addAthlete(athlete: Athlete) {
        listOfAthletes.add(athlete)
        notifyItemChanged(listOfAthletes.size - 1)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}