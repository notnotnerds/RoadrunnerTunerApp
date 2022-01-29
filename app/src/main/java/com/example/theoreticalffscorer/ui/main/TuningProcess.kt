package com.example.theoreticalffscorer.ui.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.example.theoreticalffscorer.Home
import com.example.theoreticalffscorer.R
import com.example.theoreticalffscorer.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class TuningProcess : AppCompatActivity() {
    val textView: TextView=findViewById(R.id.textView)
    var text: String = "Nothing"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
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
        dcb.setOnClickListener{ text = "Future Drive Constants Page" }
        mcb.setOnClickListener{ text = "Future Max Velocity Page" }
        flb.setOnClickListener{ text = "Future First Localization test Page" }
        dvpidb.setOnClickListener{ text = "Future Drive Velocity PID Tuner Page" }
        stb.setOnClickListener{ text = "Future Straight Test Page" }
        strb.setOnClickListener{ text = "Future Strafe Test Page" }
        twtb.setOnClickListener{ text = "Future Track Width Tuner Page" }
        ttb.setOnClickListener{ text = "Future Turn Test Page" }
        sltb.setOnClickListener{ text = "Future Second Localization test Page" }
        fpidtb.setOnClickListener{ text = "Future Follow PID Tuner Page" }
        sptb.setOnClickListener{textView -> Snackbar.make(textView, "Future Spline Test Page", Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }
        print(text)
        viewPager.adapter = sectionsPagerAdapter
        Handler().postDelayed({
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish()
        }, 3000)
        }
}