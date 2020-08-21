package com.example.monarq.ui.monarq.weekday

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.monarq.R
import com.example.monarq.databinding.ItemWeekdayBinding
import com.example.monarq.model.Weekday


class WeekdayListAdapter: RecyclerView.Adapter<WeekdayListAdapter.ViewHolder>() {
    private lateinit var weekdayList:List<Weekday>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemWeekdayBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_weekday, parent, false)
        return ViewHolder(
            binding
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weekdayList[position])
    }

    override fun getItemCount(): Int {
        return if(::weekdayList.isInitialized) weekdayList.size else 0
    }

    fun updateWeekdayList(weekdayList:List<Weekday>){
        this.weekdayList = weekdayList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemWeekdayBinding):RecyclerView.ViewHolder(binding.root){
        private val viewModel =
            WeekdayViewModel()

        fun bind(weekday:Weekday){
            viewModel.bind(weekday)
            binding.viewModelWeekday = viewModel
        }
    }
}