package com.cv.android.ui

import androidx.lifecycle.MutableLiveData
import com.cv.models.Job

class JobViewModel {

    val company : MutableLiveData<String> = MutableLiveData()
    val title : MutableLiveData<String> = MutableLiveData()
    val description : MutableLiveData<String> = MutableLiveData()
    val location : MutableLiveData<String> = MutableLiveData()
    val period : MutableLiveData<String> = MutableLiveData()

    fun bind(job : Job) {

        company.value = job.company
        title.value = job.title
        description.value = job.description
        location.value = job.location
        period.value = job.period
    }
}
