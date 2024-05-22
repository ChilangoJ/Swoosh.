package Controller

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.ToggleButton
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.swoosh.R

class LeagueActivity : AppCompatActivity() {

    private var selectedLeague = ""

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)

        val mensLeagueBtn = findViewById<ToggleButton>(R.id.mensLeagueBtn)
        val womensLeagueBtn = findViewById<ToggleButton>(R.id.womensLeagueBtn)
        val coedLeagueBtn = findViewById<ToggleButton>(R.id.coedLeagueBtn)
        val nextButton = findViewById<Button>(R.id.nextBtn)

        mensLeagueBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedLeague = "Mens"
                womensLeagueBtn.isChecked = false
                coedLeagueBtn.isChecked = false
            } else if (!womensLeagueBtn.isChecked && !coedLeagueBtn.isChecked) {
                selectedLeague = ""
            }
            updateNextButtonState(nextButton)
        }

        womensLeagueBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedLeague = "Womens"
                mensLeagueBtn.isChecked = false
                coedLeagueBtn.isChecked = false
            } else if (!mensLeagueBtn.isChecked && !coedLeagueBtn.isChecked) {
                selectedLeague = ""
            }
            updateNextButtonState(nextButton)
        }

        coedLeagueBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectedLeague = "Co-ed"
                mensLeagueBtn.isChecked = false
                womensLeagueBtn.isChecked = false
            } else if (!mensLeagueBtn.isChecked && !womensLeagueBtn.isChecked) {
                selectedLeague = ""
            }
            updateNextButtonState(nextButton)
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

    fun onMensClicked(view: View) {}
    fun onWomensClicked(view: View) {}
    fun onCoedClicked(view: View) {}
    fun LeagueNextClicked(view: View) {}
}






