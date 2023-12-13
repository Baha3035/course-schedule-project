package com.alatoo.coursescheduler.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.alatoo.coursescheduler.MainActivity
import com.alatoo.coursescheduler.dataBase.DataBase
import com.alatoo.coursescheduler.repository.UserRepository
import com.alatoo.coursescheduler.databinding.ActivityRegistrationBinding
import com.alatoo.coursescheduler.entities.User
import com.alatoo.coursescheduler.utils.Constants
import com.alatoo.coursescheduler.viewModels.UserViewModel

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var db = DataBase.getDatabase(this).userDao()
        val repository = UserRepository(db)
        viewModel = UserViewModel(repository)

        binding.registerBtn.setOnClickListener{
            val group = binding.groupEditText.text.toString()
            val userName = binding.nameEditText.text.toString()
            Constants.USER_GROUP = group
            if(!group.isEmpty() && !userName.isEmpty()){
                val user = User(0, userName, group)
                viewModel.save(user)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Enter your group and name!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}