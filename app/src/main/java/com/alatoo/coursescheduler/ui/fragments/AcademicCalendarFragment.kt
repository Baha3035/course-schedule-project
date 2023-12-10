package com.alatoo.coursescheduler.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.navigation.fragment.findNavController
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.databinding.FragmentAcademicCalendarBinding
import com.alatoo.coursescheduler.utils.Constants
import com.google.android.material.bottomnavigation.BottomNavigationView

class AcademicCalendarFragment : Fragment() {

    private lateinit var binding: FragmentAcademicCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAcademicCalendarBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomNavigationView = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView?.visibility = View.GONE
        binding.closeBtn.setOnClickListener {
            findNavController().navigateUp()
            bottomNavigationView?.visibility = View.VISIBLE
        }
        binding.calendarWebView.apply {
            webViewClient = WebViewClient()
            settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
            loadUrl(Constants.ACADEMIC_CALENDAR)
        }
    }

}