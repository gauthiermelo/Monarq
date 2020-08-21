package com.example.monarq.base

import androidx.lifecycle.ViewModel
import com.example.monarq.MainViewModel
import com.example.monarq.injection.component.DaggerViewModelInjector
import com.example.monarq.injection.component.ViewModelInjector
import com.example.monarq.injection.module.NetworkModule
import com.example.monarq.injection.module.RepositoryModule
import com.example.monarq.ui.monarq.weekday.WeekdayListViewModel
import com.example.monarq.ui.post.PostListViewModel

abstract class BaseViewModel: ViewModel(){

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .repositoryModule(RepositoryModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainViewModel -> injector.inject( this)
        }
    }

}