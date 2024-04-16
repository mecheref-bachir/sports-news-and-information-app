package com.bachir.sportsnewsandinformationapp.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bachir.sportsnewsandinformationapp.R
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.google.android.material.floatingactionbutton.FloatingActionButton


class AboutMeFragment : Fragment() {

    private lateinit var animatedTextView: TextView
    private lateinit var tvOverview: TextView
    private lateinit var tvWelcome: TextView
    private lateinit var btnFacebook: Button
    private lateinit var btnLinkedIn: Button
    private lateinit var btnGithub: Button

    private var index = 0
    private val user = Data.user

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=  inflater.inflate(R.layout.fragment_about_me, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnFacebook=view.findViewById(R.id.btnFacebook)
        btnGithub = view.findViewById(R.id.btnGithub)
        btnLinkedIn=view.findViewById(R.id.btnLinkedIn)
        tvOverview = view.findViewById(R.id.tvOverview)
        tvWelcome = view.findViewById(R.id.tvWelcome)
        animatedTextView = view.findViewById(R.id.tvSkills)


        tvOverview.text = user.description
        tvWelcome.text = "Hi, I am ${user.name}"

        animateText()
        btnFacebook.setOnClickListener {
            Data.user.urls.get("facebook")?.let { facebookUrl -> openWebSite(facebookUrl) }
        }
        btnLinkedIn.setOnClickListener {
            user.urls.get("linkedIn")?.let { linkedInUrl -> openWebSite(linkedInUrl) }
        }
        btnGithub.setOnClickListener {
            user.urls.get("github")?.let{githubUrl ->openWebSite(githubUrl)}
        }

    }

    private fun openWebSite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }

    private fun animateText() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(object : Runnable {
            var i = 0
            override fun run() {

                if (index < user.skills[i].length) {
                    animatedTextView.text = user.skills[i].subSequence(0, index + 1)
                    index++
                    handler.postDelayed(this, 200)
                } else {

                    i++
                    if (i == user.skills.size) {
                        i = 0
                    }
                    index = 0
                    handler.postDelayed(this, 2000)
                }
            }

        }, 500)
    }


}