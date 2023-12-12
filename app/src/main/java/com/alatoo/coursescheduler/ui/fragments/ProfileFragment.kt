package com.alatoo.coursescheduler.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.dataBase.DataBase
import com.alatoo.coursescheduler.repository.UserRepository
import com.alatoo.coursescheduler.databinding.FragmentProfileBinding
import com.alatoo.coursescheduler.viewModels.UserViewModel

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var db = DataBase.getDatabase(requireContext()).userDao()
        val repository = UserRepository(db)
        viewModel = UserViewModel(repository)

        viewModel.user.observe(viewLifecycleOwner, Observer{
            binding.groupTxt.text = "Group: " + it[0].course
            binding.nameTxt.text = "Name: " + it[0].name
        })

        binding.optionsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_academicCalendarFragment)
        }
        binding.editBtn.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
        }
    }

}