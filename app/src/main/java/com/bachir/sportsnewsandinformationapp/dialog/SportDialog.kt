package com.bachir.sportsnewsandinformationapp.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.fragments.SportsFragment
import com.bachir.sportsnewsandinformationapp.models.Sport
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.bachir.sportsnewsandinformationapp.utils.SportType
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.textfield.TextInputEditText

class SportDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_sport, null)

        val sportTypeDropdown = view.findViewById<Spinner>(R.id.s_sport_type)
        val sportNameEditText = view.findViewById<TextInputEditText>(R.id.tiet_sport_name)
        val instructionEditText = view.findViewById<TextInputEditText>(R.id.tiet_instruction)

        val dropdownItems = listOf(SportType.COMBAT, SportType.MEASURE,
            SportType.PLAY, SportType.PRECISION, SportType.SPECTACLE)

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, dropdownItems)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sportTypeDropdown.adapter = adapter

        var selectedItem = SportType.MEASURE
        sportTypeDropdown.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Get the selected item from the adapter
                selectedItem = dropdownItems[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                val sport = Sport(selectedItem, sportNameEditText.text.toString(),
                    instructionEditText.text.toString())

                val sportsFragment = Data.listOfFragments.get(0) as SportsFragment

                sportsFragment.addSport(sport)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}