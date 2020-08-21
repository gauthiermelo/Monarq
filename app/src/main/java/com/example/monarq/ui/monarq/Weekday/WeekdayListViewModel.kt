package com.example.monarq.ui.monarq.weekday

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.monarq.R
import com.example.monarq.base.BaseViewModel
import com.example.monarq.model.Weekday
import com.example.monarq.network.MonarqApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class WeekdayListViewModel:BaseViewModel(){
    @Inject
    lateinit var monarqApi: MonarqApi

    private lateinit var subscription: Disposable
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadWeekdays() }
    val weekdayListAdapter: WeekdayListAdapter =
        WeekdayListAdapter()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()



    init{
        loadWeekdays()
    }

    private fun loadWeekdays(){

        //var mylist = Observable<List<Weekday>>
        var a = monarqApi.getWeekdays()
    }

    private fun onRetrieveWeekdayListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveWeekdayListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveWeekdayListSuccess(weekdayList:List<Weekday>){
        weekdayListAdapter.updateWeekdayList(weekdayList)
    }

    private fun onRetrieveWeekdayListError(){
        errorMessage.value = R.string.weekday_error
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}