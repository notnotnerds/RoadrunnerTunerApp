package com.notnotnerds.roadrunnertuner.ui.tuners.drive_setup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.notnotnerds.roadrunnertuner.R

class DriveEncoderAndDriveConstants : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_drive_encoder_and_drive_constants,
            container,
            false)
    }
}