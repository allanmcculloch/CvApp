package com.cv.android.repository.remote

import com.cv.models.ContactInfo
import com.cv.models.SendMessageRequest
import com.cv.models.Job
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface CvApiEndpoints {

    @GET("/jobs")
    fun getJobs(): Observable<List<Job>>

    @GET("/contactDetails")
    fun getContactInfo(): Observable<ContactInfo>

    @POST("/sendMessage")
    fun postSendMessage(@Body request: SendMessageRequest): Observable<Response<Unit>>
}


