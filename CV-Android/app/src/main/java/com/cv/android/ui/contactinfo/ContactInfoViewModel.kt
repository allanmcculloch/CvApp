package com.cv.android.ui.contactinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.repository.ContactInfoRepository
import com.cv.android.usecases.GetContactInfoUseCase
import com.cv.models.ContactInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ContactInfoViewModel(private val getContactInfoUseCase: GetContactInfoUseCase) : ViewModel() {
    val name : MutableLiveData<String> = MutableLiveData()
    val address : MutableLiveData<String> = MutableLiveData()
    val email : MutableLiveData<String> = MutableLiveData()
    val mobile : MutableLiveData<String> = MutableLiveData()
    val webAddress : MutableLiveData<String> = MutableLiveData()
    val imageUrl : MutableLiveData<String> = MutableLiveData()

    private val contactInfo : MutableLiveData<ContactInfo> = MutableLiveData()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {
        subscription = getContactInfoUseCase.execute()
            .subscribe({
                contactInfo.value = it

                name.value = it?.name
                address.value = it?.addressLines?.joinToString(", ")
                email.value = it?.emailAddress
                mobile.value = it?.mobileContact
                webAddress.value = it?.webAddress
                imageUrl.value = it?.imageUrl
            },Throwable::printStackTrace)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
