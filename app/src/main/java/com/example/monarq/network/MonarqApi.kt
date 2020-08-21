package com.example.monarq.network

import androidx.lifecycle.MutableLiveData
import com.example.monarq.model.Member
import com.example.monarq.model.Weekday
import io.reactivex.Observable
import retrofit2.http.Body


import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MonarqApi {

    /**
     * Get the list of the weekdays from the API
     */
    @GET("/api/weekdays")
    fun getWeekdays(): Observable<Weekday>

    /**
     * Get the list of the weekdays from the API
     */
    @GET("/api/members/{MemberId}")
    fun getMember(@Query("id")memberId: String): Observable<Member>

    @POST("/api/members")
    fun createUser(@Body member:Member)

}