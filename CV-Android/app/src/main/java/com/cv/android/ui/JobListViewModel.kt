package com.cv.android.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.repository.ContactInfoRepository
import com.cv.models.ContactInfo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class JobListViewModel(private val repository: ContactInfoRepository) : ViewModel() {

    val name : MutableLiveData<String> = MutableLiveData()
    val address : MutableLiveData<String> = MutableLiveData()
    val email : MutableLiveData<String> = MutableLiveData()
    val mobile : MutableLiveData<String> = MutableLiveData()
    val webAddress : MutableLiveData<String> = MutableLiveData()

    private val contactInfo : MutableLiveData<ContactInfo> = MutableLiveData()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {

        subscription = repository.getContactInfo()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                contactInfo.value = it

                name.value = it?.name
                address.value = it?.addressLines?.joinToString(", ")
                email.value = it?.emailAddress
                mobile.value = it?.mobileContact
                webAddress.value = it?.webAddress

            },Throwable::printStackTrace)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
