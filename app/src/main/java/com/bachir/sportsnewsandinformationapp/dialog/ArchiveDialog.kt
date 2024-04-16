package com.bachir.sportsnewsandinformationapp.dialog

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.fragments.EventsFragment
import com.bachir.sportsnewsandinformationapp.fragments.HistoricalArchiveFragment
import com.bachir.sportsnewsandinformationapp.models.Archive
import com.bachir.sportsnewsandinformationapp.models.Event
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.google.android.material.textfield.TextInputEditText
import java.util.Calendar

class ArchiveDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_event, null)

        val name = view.findViewById<TextInputEditText>(R.id.tiet_name)
        val dateEditText = view.findViewById<TextInputEditText>(R.id.tiet_date)
        val date = view.findViewById<View>(R.id.v_date)
        val description = view.findViewById<TextInputEditText>(R.id.tiet_description)

        var dateSelected = Calendar.getInstance().time
        date.setOnClickListener(View.OnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(),
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    // Display the selected date
                    val selectedDateStr = "$dayOfMonth/${monthOfYear + 1}/$year"
                    dateEditText.setText(selectedDateStr)

                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(year, monthOfYear, dayOfMonth)
                    dateSelected = selectedDate.time
                }, year, month, day)

            datePickerDialog.show()
        })

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                val archive = Archive(name.text.toString(), dateSelected, description.text.toString())

                val archiveFragment = Data.listOfFragments[4] as HistoricalArchiveFragment

                archiveFragment.addArchive(archive)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}