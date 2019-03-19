package com.cv.android.ui.sendmessage

import com.cv.android.repository.remote.CvApiService
import com.cv.android.ui.BaseViewModelTest
import com.cv.models.SendMessageRequest
import com.jraska.livedata.test
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.Observable
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class SendMessageVewModelTest : BaseViewModelTest() {
    lateinit var viewModel : SendMessageViewModel
    lateinit var cvApiService: CvApiService

    @Before
    fun setUp() {

        cvApiService = mockk(relaxed = true)
        viewModel = CreateViewModel()
    }

    private fun mockSuccessfulResponse() {
        every {cvApiService.postSendMessage(testValidSendMessageRequest) }.returns(Observable.just(Response.success(Unit)))
    }

    private fun mockUnsuccessfulServerErrorResponse() {
        every {cvApiService.postSendMessage(testValidSendMessageRequest) }.returns(Observable.just(Response.error(500, ResponseBody.create(
            MediaType.get("application/json"),""))))
    }

    private fun mockUnsuccessfulRequestResponse() {
        every {cvApiService.postSendMessage(testBadSendMessageRequest) }.returns(Observable.just(Response.error(403, ResponseBody.create(
            MediaType.get("application/json"),""))))
    }

    private fun setInvalidFieldValues() {
        viewModel.name.value =  testBadSendMessageRequest.name
        viewModel.email.value = testBadSendMessageRequest.fromEmail
        viewModel.message.value = testBadSendMessageRequest.message
    }

    private fun setValidFieldValues() {
        viewModel.name.value = testValidSendMessageRequest.name
        viewModel.email.value = testValidSendMessageRequest.fromEmail
        viewModel.message.value = testValidSendMessageRequest.message
    }

    @Test
    fun sendMessageSuccessful() {
        setValidFieldValues()
        mockSuccessfulResponse()

        viewModel.sendMessage()

        verify { cvApiService.postSendMessage(testValidSendMessageRequest) }

        viewModel.sentMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)

        viewModel.formVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)

        viewModel.errorMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)
    }

    @Test
    fun sendMessageUnsuccessfulServerError() {
        setValidFieldValues()
        mockUnsuccessfulServerErrorResponse()

        viewModel.sendMessage()

        viewModel.sentMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)

        viewModel.formVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)

        viewModel.errorMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)
    }

    @Test
    fun sendMessageUnsuccessfulBadRequest() {
        setInvalidFieldValues()
        mockUnsuccessfulRequestResponse()

        viewModel.sendMessage()

        viewModel.sentMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)

        viewModel.formVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)

        viewModel.errorMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)
    }

    @Test
    fun sendMessageFailThenSuccess() {
        setInvalidFieldValues()
        mockUnsuccessfulRequestResponse()

        viewModel.sendMessage()

        viewModel.errorMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)

        mockSuccessfulResponse()
        setValidFieldValues()

        viewModel.sendMessage()

        viewModel.sentMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(true)

        viewModel.formVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)

        viewModel.errorMessageVisible.test()
            .awaitValue()
            .assertHasValue()
            .assertValue(false)
    }

    val testValidSendMessageRequest = SendMessageRequest("testName","testEmail","testMessage")
    val testBadSendMessageRequest = SendMessageRequest("","invalidEmail","")

    fun CreateViewModel() = SendMessageViewModel(cvApiService)
}