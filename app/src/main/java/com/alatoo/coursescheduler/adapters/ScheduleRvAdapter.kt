package com.alatoo.coursescheduler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.databinding.ScheduleHolderItemBinding

class ScheduleRvAdapter: RecyclerView.Adapter<ScheduleRvAdapter.ViewHolder>() {

    private var items: ArrayList<String> = ArrayList()
    private var times: ArrayList<String> = ArrayList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ScheduleHolderItemBinding.bind(itemView)
        fun bind(item: String, time: String){
            binding.subjectNameTxt.text = item
            binding.timeTxt.text = time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.schedule_holder_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], times[position])
    }

    fun setItem(newItems: ArrayList<String>, newTime: ArrayList<String>){
        items = newItems
        times = newTime
        notifyDataSetChanged()
    }


}