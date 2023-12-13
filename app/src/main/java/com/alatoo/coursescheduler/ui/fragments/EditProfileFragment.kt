package com.alatoo.coursescheduler.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.alatoo.coursescheduler.dataBase.DataBase
import com.alatoo.coursescheduler.repository.UserRepository
import com.alatoo.coursescheduler.databinding.FragmentEditProfileBinding
import com.alatoo.coursescheduler.entities.User
import com.alatoo.coursescheduler.utils.Constants
import com.alatoo.coursescheduler.viewModels.UserViewModel

class EditProfileFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var db = DataBase.getDatabase(requireContext()).userDao()
        val repository = UserRepository(db)
        viewModel = UserViewModel(repository)

        var id = 0

        viewModel.user.observe(viewLifecycleOwner, Observer{
            binding.nameEditText.setText(it[0].name)
            binding.groupEditText.setText(it[0].course)
            id = it[0].id
        })

        binding.saveBtn.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val group = binding.groupEditText.text.toString()
            val user = User(id,name, group)
            Constants.USER_GROUP = group
            viewModel.update(user)
            findNavController().navigateUp()
        }

    }

}