package com.notnotnerds.roadrunnertuner.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.notnotnerds.roadrunnertuner.R

class Settings : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

}