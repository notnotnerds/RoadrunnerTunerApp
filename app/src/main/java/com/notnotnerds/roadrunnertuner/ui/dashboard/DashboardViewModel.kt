package com.notnotnerds.roadrunnertuner.ui.dashboard

import android.webkit.WebView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "FTC Dashboard Will Reside Here"
    }

    val text: LiveData<String> = _text
}