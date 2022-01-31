package com.notnotnerds.roadrunnertuner.ui.tuners

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.notnotnerds.roadrunnertuner.MainActivity
import com.notnotnerds.roadrunnertuner.R
import com.notnotnerds.roadrunnertuner.databinding.FragmentGalleryBinding
import com.notnotnerds.roadrunnertuner.ui.dashboard.DashboardFragment

class TunerFragment : Fragment() {

    private lateinit var galleryViewModel: TunerViewModel
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        galleryViewModel = ViewModelProvider(this)[TunerViewModel::class.java]

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

}