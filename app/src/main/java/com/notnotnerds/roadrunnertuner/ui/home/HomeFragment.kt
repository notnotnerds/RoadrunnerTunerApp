package com.notnotnerds.roadrunnertuner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.notnotnerds.roadrunnertuner.databinding.FragmentHomeBinding
import android.widget.CompoundButton

import android.R
import android.widget.Switch

import android.widget.ToggleButton
import com.notnotnerds.roadrunnertuner.ui.dashboard.DashboardFragment


class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  lateinit var toggleButton: Switch
  private lateinit var chub: DashboardFragment
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

    _binding = FragmentHomeBinding.inflate(inflater, container, false)
    val root: View = binding.root
    chub=DashboardFragment()
    val textView: TextView = binding.textHome
    homeViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })
    toggleButton = root!!.findViewById(com.notnotnerds.roadrunnertuner.R.id.isCHub) as Switch
    toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
      if (isChecked) {
        toggleButton.text = "Control Hub"
        chub.setChub(true)
      } else {
        toggleButton.text = "Robot Controller Phone"
        chub.setChub(false)
      }
    }
    return root

  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
