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
import com.bachir.sportsnewsandinformationapp.fragments.NewsFragment
import com.bachir.sportsnewsandinformationapp.fragments.SportsFragment
import com.bachir.sportsnewsandinformationapp.models.News
import com.bachir.sportsnewsandinformationapp.models.Sport
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.bachir.sportsnewsandinformationapp.utils.SportType
import com.google.android.material.textfield.TextInputEditText

class NewsDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.dialog_news, null)

        val url = view.findViewById<TextInputEditText>(R.id.tiet_url)
        val title = view.findViewById<TextInputEditText>(R.id.tiet_title)
        val description = view.findViewById<TextInputEditText>(R.id.tiet_description)

        builder.setView(view)
            .setPositiveButton("OK") { dialog, _ ->
                // Handle positive button click
                val news = News(url.text.toString(), title.text.toString(), description.text.toString())

                val newsFragment = Data.listOfFragments[1] as NewsFragment

                newsFragment.addNews(news)

                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                // Handle negative button click
                dialog.dismiss()
            }
        return builder.create()
    }
}