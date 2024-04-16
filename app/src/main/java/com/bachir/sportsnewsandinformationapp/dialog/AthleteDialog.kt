package com.bachir.sportsnewsandinformationapp.dialog

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.fragments.AthletesFragment
import com.bachir.sportsnewsandinformationapp.fragments.NewsFragment
import com.bachir.sportsnewsandinformationapp.models.Athlete
import com.bachir.sportsnewsandinformationapp.models.News
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.google.android.material.textfield.TextInputEditText

class AthleteDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_athlete, null)

        val name = view.findViewById<TextInputEditText>(R.id.tiet_name)
        val competingSport = view.findViewById<TextInputEditText>(R.id.tiet_competing_sport)
        val country = view.findViewById<TextInputEditText>(R.id.tiet_country)
        val personal = view.findViewById<TextInputEditText>(R.id.tiet_personal)
        val medals = view.findViewById<TextInputEditText>(R.id.tiet_medals)
        val facts = view.findViewById<TextInputEditText>(R.id.tiet_facts)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                val athlete = Athlete(name.text.toString(), competingSport.text.toString(),
                    country.text.toString(), personal.text.toString(),
                    medals.text.toString().toInt(), facts.text.toString())

                val athleteFragment = Data.listOfFragments[2] as AthletesFragment

                athleteFragment.addAthlete(athlete)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}