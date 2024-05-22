package Controller

import Controller.FinishActivity
import Utilities.EXRA_LEAGUE
import Utilities.EXTRA_LEAGUE
import Utilities.EXTRA_SKILL
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.result.contract.ActivityResultContracts
import com.example.swoosh.R
import com.example.swoosh.R.id.ballerSkillBtn
import com.example.swoosh.R.id.beginnerSkillBtn
import com.example.swoosh.R.id.selectedLeagueTextView
import com.example.swoosh.R.id.skillFinishBtn
import kotlinx.coroutines.selects.select
import Controller.FinishActivity as ControllerFinishActivity

class SkillActivity : BaseActivity() {

    var league = ""
    var skill = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        val beginnerSkillBtn = findViewById<ToggleButton>(R.id.beginnerSkillBtn)
        val ballerSkillBtn = findViewById<ToggleButton>(R.id.ballerSkillBtn)


        beginnerSkillBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                skill = "beginner"
                ballerSkillBtn.isChecked = false
            } else if (!beginnerSkillBtn.isChecked && !ballerSkillBtn.isChecked) {
                skill = ""

            }

        }
        ballerSkillBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                skill = "baller"
                beginnerSkillBtn.isChecked = false

            } else if (!ballerSkillBtn.isChecked && !beginnerSkillBtn.isChecked) {
                skill = ""
            }
            fun onSkillFinishClicked (view: View) {
                if (skill != "") {
                    val FinishActivity = Intent(this, ControllerFinishActivity::class.java)
                    FinishActivity.putExtra(EXTRA_LEAGUE, league)
                    FinishActivity.putExtra(EXTRA_SKILL, skill)
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
}