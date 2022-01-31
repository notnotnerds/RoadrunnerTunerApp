package com.notnotnerds.roadrunnertuner.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
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

class DashboardFragment : Fragment() {

  private lateinit var dashboardViewModel: DashboardViewModel
  private var _binding: FragmentDashboardBinding? = null
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
    if(chub){
    dashView.loadUrl("192.168.43.1:8080/dash")}
    else{
      dashView.loadUrl("192.168.49.1:8080/dash")
    }

    val dashViewSettings = dashView.settings
    dashViewSettings.javaScriptEnabled = true
    dashViewSettings.allowContentAccess = true



    val textView: TextView = binding.textDashboard
    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
    })

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