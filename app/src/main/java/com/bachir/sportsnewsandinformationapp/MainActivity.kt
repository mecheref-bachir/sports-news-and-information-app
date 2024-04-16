package com.bachir.sportsnewsandinformationapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bachir.sportsnewsandinformationapp.databinding.ActivityMainBinding
import com.bachir.sportsnewsandinformationapp.dialog.ArchiveDialog
import com.bachir.sportsnewsandinformationapp.dialog.AthleteDialog
import com.bachir.sportsnewsandinformationapp.dialog.EventDialog
import com.bachir.sportsnewsandinformationapp.dialog.NewsDialog
import com.bachir.sportsnewsandinformationapp.dialog.SportDialog
import com.bachir.sportsnewsandinformationapp.sampledata.Data
import com.bachir.sportsnewsandinformationapp.utils.FragmentsIndex
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var tlMain: TabLayout
    private lateinit var vpMain: ViewPager2
    private lateinit var ibNewsShortcut: ImageButton
    private lateinit var ibEventsShortcut: ImageButton
    private lateinit var ibArchiveShortcut: ImageButton
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tlMain = findViewById(R.id.tlMain)
        vpMain = findViewById(R.id.vpMain)
        fab = findViewById(R.id.fab)
        vpMain.adapter = PagerAdapter(this, Data.listOfFragments)
        TabLayoutMediator(tlMain, vpMain) { tab, index ->
            tab.text = Data.listOfFragmentsNames[index]
        }.attach()

        ibNewsShortcut = findViewById(R.id.ibNewsShortcut)
        ibEventsShortcut = findViewById(R.id.ibEventsShortcut)
        ibArchiveShortcut = findViewById(R.id.ibArchiveShortcut)


        vpMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (vpMain.currentItem == FragmentsIndex.ABOUT_ME.index) {
                    fab.hide()
                } else {
                    fab.show()
                }
            }
        })

        fab.setOnClickListener(View.OnClickListener {
            when(vpMain.currentItem) {
                0 -> {
                    val sportDialog = SportDialog()
                    sportDialog.show(supportFragmentManager, "Sport Dialog")
                }
                1 -> {
                    val newsDialog = NewsDialog()
                    newsDialog.show(supportFragmentManager, "News Dialog")
                }
                2 -> {
                    val athleteDialog = AthleteDialog()
                    athleteDialog.show(supportFragmentManager, "Athlete Dialog")
                }
                3 -> {
                    val eventDialog = EventDialog()
                    eventDialog.show(supportFragmentManager, "Event Dialog")
                }
                4 -> {
                    val archiveDialog = ArchiveDialog()
                    archiveDialog.show(supportFragmentManager, "Archive Dialog")
                }
            }
        })

        ibNewsShortcut.setOnClickListener {
            vpMain.currentItem = FragmentsIndex.News.index
        }
        ibEventsShortcut.setOnClickListener {
            vpMain.currentItem = FragmentsIndex.EVENTS.index
        }
        ibArchiveShortcut.setOnClickListener {
            vpMain.currentItem = FragmentsIndex.HISTORICAL_ARCHIVES.index
        }


    }

}