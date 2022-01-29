package com.example.theoreticalffscorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val goTune: Button = findViewById(R.id.button2)
        goTune.setOnClickListener {
                textView -> Snackbar.make(textView,"Something worked!", Snackbar.LENGTH_LONG).setAction("Action", null).show()
            // your code to perform when the user clicks on the button
            setContentView(R.layout.tuner_intro_fragment)
        }
    }
}