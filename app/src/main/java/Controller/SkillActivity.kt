package Controller

import Controller.FinishActivity
import Model.Player
import Utilities.EXTRA_PLAYER
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import com.example.swoosh.R
import Controller.FinishActivity as ControllerFinishActivity

fun text(s: String) {

}


class SkillActivity : BaseActivity() {

    lateinit var player: Player
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!

        val beginnerSkillBtn = findViewById<ToggleButton>(R.id.beginnerSkillBtn)
        val ballerSkillBtn = findViewById<ToggleButton>(R.id.ballerSkillBtn)

        val searchLeagueText: TextView = findViewById(R.id.searchLeagueTxts)
        searchLeagueText.text = "Lookiing for ${player.league} ${player.Skill} league near you..."


        beginnerSkillBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                player.Skill = "beginner"
                ballerSkillBtn.isChecked = false
            } else if (!beginnerSkillBtn.isChecked && !ballerSkillBtn.isChecked) {
                player.Skill = ""

            }

        }
        ballerSkillBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                player.Skill = "baller"
                beginnerSkillBtn.isChecked = false

            } else if (!ballerSkillBtn.isChecked && !beginnerSkillBtn.isChecked) {
                player.Skill = ""
            }
            fun onSkillFinishClicked (view: View) {
                if (player.Skill != "") {
                    val FinishActivity = Intent(this, ControllerFinishActivity::class.java)
                    FinishActivity.putExtra(EXTRA_PLAYER, player)
                    startActivity(FinishActivity)
                } else {
                    Toast.makeText(this, "Please select a skill level", Toast. LENGTH_SHORT).show()
                }
            }
        }
    }


    fun onSkillFinishClicked(view: View) {
        val finishActivityIntent = Intent(this, FinishActivity::class.java)
        startActivity(finishActivityIntent)

        fun onBeginnerClick(view: View) {
        }

        fun onBallerClick(view: View) {
        }
    }

    companion object {
        fun putExtra(extraPlayer: String, player: Player) {

        }
    }
}