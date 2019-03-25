package com.cv.android.ui.contactinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.repository.ContactInfoRepository
import com.cv.android.usecases.GetContactInfoUseCase
import com.cv.models.ContactInfo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class ContactInfoViewModel(private val getContactInfoUseCase: GetContactInfoUseCase) : ViewModel() {
    private val _name : MutableLiveData<String> = MutableLiveData()
    private val _address : MutableLiveData<String> = MutableLiveData()
    private val _email : MutableLiveData<String> = MutableLiveData()
    private val _mobile : MutableLiveData<String> = MutableLiveData()
    private val _webAddress : MutableLiveData<String> = MutableLiveData()
    private val _imageUrl : MutableLiveData<String> = MutableLiveData()

    val name : LiveData<String> = _name
    val address : LiveData<String> = _address
    val email : LiveData<String> = _email
    val mobile : LiveData<String> = _mobile
    val webAddress : LiveData<String> = _webAddress
    val imageUrl : LiveData<String> = _imageUrl

    private val contactInfo : MutableLiveData<ContactInfo> = MutableLiveData()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {
        subscription = getContactInfoUseCase.execute()
            .subscribe({
                contactInfo.value = it

                _name.value = it?.name
                _address.value = it?.addressLines?.joinToString(", ")
                _email.value = it?.emailAddress
                _mobile.value = it?.mobileContact
                _webAddress.value = it?.webAddress
                _imageUrl.value = it?.imageUrl
            },Throwable::printStackTrace)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
