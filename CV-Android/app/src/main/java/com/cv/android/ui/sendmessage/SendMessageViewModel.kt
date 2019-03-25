package com.cv.android.ui.sendmessage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cv.android.usecases.SendMessageUseCase
import com.cv.models.SendMessageRequest
import io.reactivex.disposables.Disposable

class SendMessageViewModel(private val sendMessageUseCase: SendMessageUseCase) : ViewModel() {
    private val _errorMessageVisible: MutableLiveData<Boolean> = MutableLiveData()
    private val _sentMessageVisible: MutableLiveData<Boolean> = MutableLiveData()
    private val _formVisible: MutableLiveData<Boolean> = MutableLiveData()

    val name: MutableLiveData<String> = MutableLiveData()
    val email: MutableLiveData<String> = MutableLiveData()
    val message: MutableLiveData<String> = MutableLiveData()
    val errorMessageVisible : LiveData<Boolean> = _errorMessageVisible
    val sentMessageVisible : LiveData<Boolean> = _sentMessageVisible
    val formVisible : LiveData<Boolean> = _formVisible

    private lateinit var subscription: Disposable

    init {
        _formVisible.value = true
        _sentMessageVisible.value = false
        _errorMessageVisible.value = false
    }

    fun sendMessage() {
        val message = SendMessageRequest(name.value ?: "", email.value ?: "", message.value ?: "")

        subscription = sendMessageUseCase.execute(message)
            .subscribe({

                if (it.isSuccessful) {
                    _formVisible.value = false
                    _sentMessageVisible.value = true
                    _errorMessageVisible.value = false
                }
                else {
                    _errorMessageVisible.value = true
                }

            }, {
                _errorMessageVisible.value = true
            })
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
