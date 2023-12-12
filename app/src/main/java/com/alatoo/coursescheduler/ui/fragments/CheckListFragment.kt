package com.alatoo.coursescheduler.ui.fragments

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.adapters.CheckListRvAdapter
import com.alatoo.coursescheduler.dataBase.DataBase
import com.alatoo.coursescheduler.repository.Repository
import com.alatoo.coursescheduler.databinding.FragmentCheckListBinding
import com.alatoo.coursescheduler.entities.TaskItem
import com.alatoo.coursescheduler.viewModels.MainViewModel
import com.alatoo.coursescheduler.viewModels.ViewModelFactory

class CheckListFragment : Fragment() {

    private lateinit var binding: FragmentCheckListBinding
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCheckListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var db = DataBase.getDatabase(requireContext()).taskItemDao()
        val repository = Repository(db)
        mainViewModel = ViewModelProvider(this, ViewModelFactory(repository)).get(MainViewModel::class.java)

        val adapter = CheckListRvAdapter()
        mainViewModel.items.observe(viewLifecycleOwner, Observer {
            adapter.setList(it)
        })
        binding.checkListRv.layoutManager = LinearLayoutManager(requireContext())
        binding.checkListRv.adapter = adapter
        adapter.update = {
            mainViewModel.updateItem(it)
        }
        binding.addNewTaskBtn.setOnClickListener {
            callAlertDialogToMaps()
        }
    }

    private fun callAlertDialogToMaps(){

        val dialogScreen = Dialog(requireContext())
        dialogScreen.setContentView(R.layout.alert_dialog)
        dialogScreen.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val createBtn = dialogScreen.findViewById<Button>(R.id.createBtn)
        val cancelBtn = dialogScreen.findViewById<Button>(R.id.cancelBtn)
        val input = dialogScreen.findViewById<EditText>(R.id.taskNameEditTxt)

        createBtn.setOnClickListener {
            mainViewModel.insertItem(TaskItem(0, input.text.toString()))
            dialogScreen.dismiss()
        }
        cancelBtn.setOnClickListener {
            dialogScreen.dismiss()
        }
        dialogScreen.show()
    }

}