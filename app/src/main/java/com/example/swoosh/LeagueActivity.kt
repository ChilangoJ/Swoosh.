package com.example.swoosh

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ToggleButton
import android.view.View
import android.widget.Button
import android.widget.Toast


class LeagueActivity : BaseActivity() {
    private var selectedLeague = ""

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val mensLeagueBtn = findViewById<ToggleButton>(R.id.mensLeagueBtn)
        val womensLeagueBtn = findViewById<ToggleButton>(R.id.womensLeagueBtn)
        val coedLeagueBtn = findViewById<ToggleButton>(R.id.coedLeagueBtn)
        val nextButton = findViewById<Button>(R.id.nextBtn)

        mensLeagueBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedLeague = "Mens"
                updateNextButtonState(nextButton)
            }
        }

        womensLeagueBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedLeague = "Womens"
                updateNextButtonState(nextButton)
            }
        }

        coedLeagueBtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                selectedLeague = "Co-ed"
                updateNextButtonState(nextButton)
            }
        }

        nextButton.setOnClickListener {
            if (selectedLeague.isNotEmpty()) {
                val skillActivityIntent = Intent(this, SkillActivity::class.java)
                startActivity(skillActivityIntent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun updateNextButtonState(nextButton: Button) {
        nextButton.isEnabled = selectedLeague.isNotEmpty()
    }

    fun LeagueNextClicked(view: View) {}
    fun onCoedClicked(view: View) {}
    fun onWomensClicked(view: View) {}
    fun onMensClicked(view: View) {}
}






