package com.example.profileapp

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        val nameText = findViewById<TextView>(R.id.nameText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val currentJobText = findViewById<TextView>(R.id.currentJobText)
        val experienceText = findViewById<TextView>(R.id.experienceText)
        val experienceExpandableList = findViewById<ExpandableListView>(R.id.experienceExpandableList)

        nameText.text = getString(R.string.profile_name)
        descriptionText.text = getString(R.string.profile_description)
        currentJobText.text = getString(R.string.current_job)
        experienceText.text = getString(R.string.profile_experience)

        val experienceTitles = resources.getStringArray(R.array.experience_titles).toList()
        val experienceDetails = listOf(
            getString(R.string.experience_1_details),
            getString(R.string.experience_2_details),
            getString(R.string.experience_3_details),
            getString(R.string.experience_4_details)
        )

        val adapter = ExperienceAdapter(this, experienceTitles, experienceDetails)
        experienceExpandableList.setAdapter(adapter)

        profileImage.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_message), Toast.LENGTH_SHORT).show()
        }
    }
}
