package com.example.monarq

import com.example.monarq.base.BaseViewModel
import com.example.monarq.model.Member
import com.example.monarq.network.MonarqApi
import com.example.monarq.network.Repository
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import javax.inject.Inject

class MainViewModel : BaseViewModel(){

    @Inject
    lateinit var repository: Repository
    private lateinit var subscription: Disposable
    private val user = FirebaseAuth.getInstance().currentUser

    init{
        initialScreen()
    }

    private fun initialScreen(){
        val id=user?.uid
        if(!id.isNullOrEmpty()){
          loadMember(id)
        }
    }

    private fun loadMember(Id: String){

        subscription = repository.getMember(Id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { println("!!!Do On Suscribe!") }
            .doOnTerminate { println("!!!Do On Terminate!") }
            .subscribe(
                // Add result
                { result -> onRetrieveMemberSuccess(result) },
                { error -> onRetrieveMemberError(error) }
            )
    }

    private fun onRetrieveMemberSuccess(member: Member){
        println("!!!onRetrieveMemberSuccess")
    }

    private fun onRetrieveMemberError(error:Throwable){
        println("!!!onRetrieveMemberError")
        if(error is HttpException){
            when(error.code()){
                400 ->  createUser()
                200 ->  println("Code 200!!!")
                else -> println( "Autre Code!!!")
            }
        }

        //if status 400: user doesn't exist, create!
        //else: network error, leave!
    }

    fun createUser(){
        println("!!!Creating a user")
    }
}