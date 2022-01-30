package com.notnotnerds.roadrunnertuner.ui.tuners

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TunerViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "The Tuning Section Will Live Here"
    }
    val text: LiveData<String> = _text
}