package com.notnotnerds.roadrunnertuner.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.notnotnerds.roadrunnertuner.databinding.FragmentHomeBinding

import android.R
import android.content.Context
import android.util.Log
import android.webkit.ConsoleMessage
import android.widget.*
import androidx.fragment.app.FragmentTransaction

import com.notnotnerds.roadrunnertuner.ui.dashboard.DashboardFragment
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter


class HomeFragment : Fragment() {

  private lateinit var homeViewModel: HomeViewModel
private var _binding: FragmentHomeBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  lateinit var toggleButton: Switch

  val fileName = "RRTvars"

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
    toggleButton = root!!.findViewById(com.notnotnerds.roadrunnertuner.R.id.isCHub) as Switch
    toggleButton.setOnCheckedChangeListener { _, isChecked ->
      if (isChecked) {
        toggleButton.text = "Control Hub"
        Toast.makeText(requireContext(), "Control Hub Selected", Toast.LENGTH_SHORT).show()
        chub.setChub(true)

        context!!.openFileOutput(fileName, Context.MODE_PRIVATE).use { it.write("Yes".toByteArray()) }

        Log.d("FRR","Created the File Baby - Yes")
      }

      else {
        toggleButton.text = "Robot Controller Phone"
        Toast.makeText(requireContext(), "Robot Controller Phone Selected", Toast.LENGTH_SHORT).show()
        chub.setChub(false)

        context!!.openFileOutput(fileName, Context.MODE_PRIVATE).use { it.write("No".toByteArray()) }
        Log.d("FRR","Created the File Baby - No")
      }
    }
    return root

  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
