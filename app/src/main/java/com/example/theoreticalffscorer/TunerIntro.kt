package com.example.theoreticalffscorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.theoreticalffscorer.R
import com.google.android.material.snackbar.Snackbar

class TunerIntro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("we got to 12")
        setContentView(R.layout.tuner_intro_fragment)
        val dcb: Button = findViewById(R.id.driveConstantsButton)
        val mcb: Button = findViewById(R.id.maxVelocityButton)
        val flb: Button = findViewById(R.id.firstLocalizationTest1Button)
        val dvpidb: Button = findViewById(R.id.driveVeloPIDTunerButton)
        val stb: Button = findViewById(R.id.straightTestButton)
        val strb: Button = findViewById(R.id.strafeTestButton)
        val twtb: Button = findViewById(R.id.trackWidthTunerButton)
        val ttb: Button = findViewById(R.id.turnTestButton)
        val sltb: Button = findViewById(R.id.secondLocalizationTestButton)
        val fpidtb: Button = findViewById(R.id.followerPIDTunerButton)
        val sptb: Button = findViewById(R.id.splineTestButton)
        print("we got to 24")
        dcb.setOnClickListener{
                textView -> Snackbar.make(textView,"Future Drive Constants Page", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            setContentView(R.layout.activity_home)

        }
        mcb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Max Velocity Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        flb.setOnClickListener{ textView -> Snackbar.make(textView, "Future First Localization test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        dvpidb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Drive Velocity PID Tuner Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        stb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Straight Test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        strb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Strafe Test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        twtb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Track Width Tuner Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        ttb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Turn Test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        sltb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Second Localization test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        fpidtb.setOnClickListener{ textView -> Snackbar.make(textView, "Future Follow PID Tuner Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }
        sptb.setOnClickListener{textView -> Snackbar.make(textView, "Future Spline Test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show() }

    }
}