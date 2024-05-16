package com.example.swoosh

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ToggleButton
import android.view.View

class LeagueActivity : BaseActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val mensLeagueBtn: ToggleButton = findViewById(R.id.mensLeagueBtn)
        val womensLeagueBtn: ToggleButton = findViewById(R.id.womensLeagueBtn)
        val coedLeagueBtn: ToggleButton = findViewById(R.id.coedLeagueBtn)

        mensLeagueBtn.text = "Men's League"
        womensLeagueBtn.text = "Women's League"
        coedLeagueBtn.text = "Co-ed League"

        mensLeagueBtn.setOnClickListener { onMensChecked(mensLeagueBtn, listOf(womensLeagueBtn, coedLeagueBtn)) }
        womensLeagueBtn.setOnClickListener { onWomensChecked(womensLeagueBtn, listOf(mensLeagueBtn, coedLeagueBtn)) }
        coedLeagueBtn.setOnClickListener { onCoedChecked(coedLeagueBtn, listOf(mensLeagueBtn, womensLeagueBtn)) }
    }

    private fun onMensChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onWomensChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onCoedChecked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        onToggleButtonClicked(clickedButton, otherButtons)
    }

    private fun onToggleButtonClicked(clickedButton: ToggleButton, otherButtons: List<ToggleButton>) {
        otherButtons.forEach { button ->
            if (button.isChecked) {
                button.isChecked = false
            }
        }
        clickedButton.isChecked = true
    }

    fun LeagueNextClicked(view: View) {
        val SkillActivity = Intent(this,SkillActivity::class.java)
        startActivity(SkillActivity)
    }

    fun onCoedClicked(view: View) {}
    fun onWomensClicked(view: View) {}
    fun onMensClicked(view: View) {}
}



