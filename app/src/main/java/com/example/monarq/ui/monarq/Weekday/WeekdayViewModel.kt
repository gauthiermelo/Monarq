package com.example.monarq.ui.monarq.weekday

import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.monarq.base.BaseViewModel
import com.example.monarq.databinding.ItemWeekdayBinding
import com.example.monarq.model.Weekday

class WeekdayViewModel: BaseViewModel() {


    private val weekdayId = MutableLiveData<String>()
    private val weekdayDescription = MutableLiveData<String>()

    fun bind(weekday: Weekday){
        weekdayId.value = weekday.Id.toString()
        weekdayDescription.value = weekday.Description
    }

    fun getWeekdayId():MutableLiveData<String>{
        return weekdayId
    }

    fun getWeekdayDescription():MutableLiveData<String>{
        return weekdayDescription
    }

    class ViewHolder(private val binding: ItemWeekdayBinding): RecyclerView.ViewHolder(binding.root){
        private val viewModel =
            WeekdayViewModel()

        fun bind(weekday:Weekday){
            viewModel.bind(weekday)
            binding.viewModelWeekday = viewModel
        }
    }

}