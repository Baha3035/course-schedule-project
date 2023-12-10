package com.alatoo.coursescheduler.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alatoo.coursescheduler.R
import com.alatoo.coursescheduler.databinding.CheckListItemBinding
import com.alatoo.coursescheduler.entities.TaskItem

class CheckListRvAdapter: RecyclerView.Adapter<CheckListRvAdapter.ViewHolder>() {

    private val items: List<TaskItem> = emptyList()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = CheckListItemBinding.bind(itemView)
        fun bind(item: TaskItem){
            binding.taskNameTxt.text = item.name
            binding.checkbox.isChecked = item.done
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_main, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}