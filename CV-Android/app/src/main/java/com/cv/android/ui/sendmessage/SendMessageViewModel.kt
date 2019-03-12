package com.cv.android.ui.sendmessage

import android.text.BoringLayout
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.repository.remote.CvApiService
import com.cv.models.SendMessageRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class SendMessageViewModel(private val cvApiService: CvApiService) : ViewModel() {

    val name : MutableLiveData<String> = MutableLiveData()
    val email : MutableLiveData<String> = MutableLiveData()
    val message : MutableLiveData<String> = MutableLiveData()

    val errorMessageVisibile : MutableLiveData<Boolean> = MutableLiveData()
    val sentMessageVisibile : MutableLiveData<Boolean> = MutableLiveData()
    val formVisible : MutableLiveData<Boolean> = MutableLiveData()

    private lateinit var subscription: Disposable

    init {
        formVisible.value = true
        sentMessageVisibile.value = false
        errorMessageVisibile.value = false
    }

    fun sendMessage() {

        subscription = cvApiService.postSendMessage(SendMessageRequest(name.value ?: "", email.value ?: "", message.value ?: ""))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                if (it.isSuccessful) {
                    formVisible.value = false
                    sentMessageVisibile.value = true
                    errorMessageVisibile.value = false
                }
                else {
                    errorMessageVisibile.value = true
                }

            }, {
                errorMessageVisibile.value = true
            })
    }

    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }
}
