package com.alatoo.coursescheduler.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.alatoo.coursescheduler.MainActivity
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.dataBase.DataBase
import com.alatoo.coursescheduler.databinding.ActivitySplashScreenBinding
import com.alatoo.coursescheduler.repository.UserRepository
import com.alatoo.coursescheduler.utils.Constants
import com.alatoo.coursescheduler.viewModels.UserViewModel

class SplashScreenActivity : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = DataBase.getDatabase(this).userDao()
        val repository = UserRepository(db)
        viewModel = UserViewModel(repository)

        binding.root.alpha = 0f
        binding.root.animate().setDuration(2500).alpha(1f).withEndAction{
            viewModel.user.observe(this, Observer{
                if(!it.isEmpty()){
                    Constants.USER_GROUP = it[0].course
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    val intent = Intent(this, RegistrationActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            })
        }
        
    }
}