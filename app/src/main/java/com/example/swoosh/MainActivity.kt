package com.example.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : BaseActivity () {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val getStartedBtn = findViewById<TextView>(R.id.nextBtn)

        getStartedBtn.setOnClickListener {
            val leagueIntent = Intent(this,LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}
