package com.example.monarq.injection.component

import com.example.monarq.MainViewModel
import com.example.monarq.injection.module.NetworkModule
import com.example.monarq.network.Repository
import com.example.monarq.ui.monarq.weekday.WeekdayListViewModel
import com.example.monarq.ui.post.PostListViewModel
import dagger.Component
import javax.inject.Singleton


/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface RepositoryInjector {
    /**
     * Injects required dependencies into the specified MainViewModel.
     * @param mainViewModel mainViewModel in which to inject the dependencies
     */
    fun inject(repository:Repository)

    @Component.Builder
    interface Builder {
        fun build(): RepositoryInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}