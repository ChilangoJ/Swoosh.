package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LeagueActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
        val nextBtn = findViewById<TextView>(R.id.nextBtn)

        nextBtn.setOnClickListener {
            val LeagueIntent = Intent(this,LeagueActivity::class.java)
            startActivity(LeagueIntent)
        }
    }
}