package com.example.monarq.network

import com.example.monarq.MainViewModel
import com.example.monarq.injection.component.DaggerRepositoryInjector
import com.example.monarq.injection.component.DaggerViewModelInjector
import com.example.monarq.injection.component.RepositoryInjector
import com.example.monarq.injection.component.ViewModelInjector
import com.example.monarq.injection.module.NetworkModule
import com.example.monarq.injection.module.RepositoryModule
import com.example.monarq.model.Member
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Inject

class Repository {

    @Inject
    lateinit var monarqApi: MonarqApi


    private val injector: RepositoryInjector = DaggerRepositoryInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
     injector.inject( this)
    }

    fun getMember(id: String):Observable<Member>{
        println("!!!Creating a user")
        return monarqApi.getMember(id)
    }

    fun createUser(member:Member){
        //Repository.
    }
}