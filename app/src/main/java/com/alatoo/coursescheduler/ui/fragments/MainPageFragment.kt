package com.alatoo.coursescheduler.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alatoo.coursescheduler.adapters.ScheduleRvAdapter
import com.alatoo.coursescheduler.databinding.FragmentMainPageBinding
import com.alatoo.coursescheduler.utils.Constants
import com.alatoo.coursescheduler.viewModels.ScheduleViewModel

class MainPageFragment : Fragment() {

    lateinit var binding: FragmentMainPageBinding
    val adapter1 = ScheduleRvAdapter()
    val adapter2 = ScheduleRvAdapter()
    val adapter3 = ScheduleRvAdapter()
    val adapter4 = ScheduleRvAdapter()
    val adapter5 = ScheduleRvAdapter()
    val adapter6 = ScheduleRvAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainPageBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ScheduleViewModel()
        super.onViewCreated(view, savedInstanceState)
        var courses: List<List<String>> = emptyList()

        viewModel.getSchedule()
        viewModel.scheduleResponse.observe(viewLifecycleOwner, Observer{
            val time = ArrayList<String>(it.values[2])
            time.remove("")
            time.remove("")
            courses = filterScheduleGroup(it.values)
            setMonday(courses[0], time)
            setTuesday(courses[1], time)
            setWednesday(courses[2], time)
            setThursday(courses[3], time)
            setFriday(courses[4], time)
            setSaturday(courses[5], time)
        })

    }

    fun filterScheduleGroup(schedule: List<List<String>>): List<List<String>> {
        val filteredSchedule = mutableListOf<List<String>>()
        for (entry in schedule) {
            if (entry.getOrNull(1) == Constants.USER_GROUP) {
                filteredSchedule.add(entry)
            }
        }

        return filteredSchedule
    }


    fun setMonday(courses: List<String>, time: ArrayList<String>){
        binding.mondayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter1.setItem(array, time)
        binding.mondayRv.adapter = adapter1
    }

    fun setTuesday(courses: List<String>, time: ArrayList<String>){
        binding.tuestayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter2.setItem(array, time)
        binding.tuestayRv.adapter = adapter2
    }

    fun setWednesday(courses: List<String>, time: ArrayList<String>){
        binding.wednesdayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter3.setItem(array, time)
        binding.wednesdayRv.adapter = adapter3
    }

    fun setThursday(courses: List<String>, time: ArrayList<String>){
        binding.thursdayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter4.setItem(array, time)
        binding.thursdayRv.adapter = adapter4
    }

    fun setFriday(courses: List<String>, time: ArrayList<String>){
        binding.fridayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter5.setItem(array, time)
        binding.fridayRv.adapter = adapter5
    }

    fun setSaturday(courses: List<String>, time: ArrayList<String>){
        binding.saturdayRv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val array = ArrayList<String>(courses)
        array.removeAt(0)
        array.remove(Constants.USER_GROUP)
        adapter6.setItem(array, time)
        binding.saturdayRv.adapter = adapter6
    }

}