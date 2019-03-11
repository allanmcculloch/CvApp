package com.cv.android.network

import com.cv.models.ContactInfo
import com.cv.models.ContactRequest
import com.cv.models.Job
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface CvApi {

    @GET("/jobs")
    fun getJobs(): Observable<List<Job>>

    @GET("/contactDetails")
    fun getContactInfo(): Observable<ContactInfo>

    @POST("/contactRequest")
    fun postContactRequest(@Body request: ContactRequest): Response<Unit>
}



