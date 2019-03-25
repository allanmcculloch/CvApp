package com.cv.android.ui.joblist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cv.models.Job

class JobViewModel {
    private val _company : MutableLiveData<String> = MutableLiveData()
    private val _title : MutableLiveData<String> = MutableLiveData()
    private val _description : MutableLiveData<String> = MutableLiveData()
    private val _location : MutableLiveData<String> = MutableLiveData()
    private val _period : MutableLiveData<String> = MutableLiveData()
    private val _imageUrl : MutableLiveData<String> = MutableLiveData()

    val company : LiveData<String> = _company
    val title : LiveData<String> = _title
    val description : LiveData<String> = _description
    val location : LiveData<String> = _location
    val period : LiveData<String> = _period
    val imageUrl : LiveData<String> = _imageUrl

    fun bind(job : Job) {
        _company.value = job.company
        _title.value = job.title
        _description.value = job.description
        _location.value = job.location
        _period.value = job.period
        _imageUrl.value = job.imageUrl
    }
}
