package com.notnotnerds.roadrunnertuner.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.notnotnerds.roadrunnertuner.MainActivity
import com.notnotnerds.roadrunnertuner.R
import com.notnotnerds.roadrunnertuner.databinding.FragmentDashboardBinding
import com.notnotnerds.roadrunnertuner.ui.home.HomeFragment
import java.io.*
import java.nio.channels.FileChannel.open

class DashboardFragment : Fragment() {

  private lateinit var dashboardViewModel: DashboardViewModel
  private var _binding: FragmentDashboardBinding? = null
  private val HF: HomeFragment = HomeFragment()
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
  var chub=true //control hub or robot controller phone
  @SuppressLint("SetJavaScriptEnabled")
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

    _binding = FragmentDashboardBinding.inflate(inflater, container, false)
    val root: View = binding.root

    val dashView = root.findViewById<WebView>(R.id.dashView)



    val useLines = context!!.openFileInput("RRTvars").bufferedReader().readLine()

    if (useLines.contains("Yes")){
      dashView.loadUrl("http://example.com/")
    }
    else{
      dashView.loadUrl("https://acmerobotics.github.io/")
    }

    Log.d("Magic, baby", useLines)


    val dashViewSettings = dashView.settings
    dashViewSettings.javaScriptEnabled = true
    dashViewSettings.allowContentAccess = true


    return root

  }
  @JvmName("setChub1")
  fun setChub(yes: Boolean){
    chub = yes
  }
override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}