package com.cv.android.ui.sendmessage

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.usecases.SendMessageUseCase
import com.cv.models.SendMessageRequest
import io.reactivex.disposables.Disposable

class SendMessageViewModel(private val sendMessageUseCase: SendMessageUseCase) : ViewModel() {
    val name : MutableLiveData<String> = MutableLiveData()
    val email : MutableLiveData<String> = MutableLiveData()
    val message : MutableLiveData<String> = MutableLiveData()

    val errorMessageVisible : MutableLiveData<Boolean> = MutableLiveData()
    val sentMessageVisible : MutableLiveData<Boolean> = MutableLiveData()
    val formVisible : MutableLiveData<Boolean> = MutableLiveData()

    private lateinit var subscription: Disposable

    init {
        formVisible.value = true
        sentMessageVisible.value = false
        errorMessageVisible.value = false
    }

    fun sendMessage() {
        val message = SendMessageRequest(name.value ?: "", email.value ?: "", message.value ?: "")

        subscription = sendMessageUseCase.execute(message)
            .subscribe({

                if (it.isSuccessful) {
                    formVisible.value = false
                    sentMessageVisible.value = true
                    errorMessageVisible.value = false
                }
                else {
                    errorMessageVisible.value = true
                }

            }, {
                errorMessageVisible.value = true
            })
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
