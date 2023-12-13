package com.alatoo.coursescheduler.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.alpha = 0f
        binding.root.animate().setDuration(2500).alpha(1f).withEndAction{
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            finish()
        }
        
    }
}