package com.example.swoosh

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton


class LeagueActivity : BaseActivity() {

    var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

    }

    val mensLeagueBtn = findViewById<ToggleButton>(R.id.mensLeagueBtn)
    val womensLeagueBtn = findViewById<ToggleButton>(R.id.womensLeagueBtn)
    val coedLeagueBtn = findViewById<ToggleButton>(R.id.coedLeagueBtn)

    private fun onMensChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onWomensChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onCoedChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onToggleButtonClicked(
        clickedButton: ToggleButton,
        otherButtons: List<ToggleButton>
    ) {
        otherButtons.forEach { button ->
            if (button.isChecked) {
                button.isChecked = false
            }
        }
        clickedButton.isChecked = true

        fun leagueNextClicked(view: View) {
            if (selectedLeague != "") {
                val SkillActivity = Intent(this, SkillActivity::class.java)
                startActivity(SkillActivity)
            } else
                Toast.makeText(this,"Please select a league.", Toast.LENGTH_SHORT)
        }
    }

    fun LeagueNextClicked(view: View) {}
}

