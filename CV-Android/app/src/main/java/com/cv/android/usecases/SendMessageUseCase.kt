package com.cv.android.usecases

import com.cv.android.repository.remote.CvApiService
import com.cv.models.SendMessageRequest
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Response

class SendMessageUseCase(private val cvApiService: CvApiService, threadExecuter: Scheduler = Schedulers.io()) :
    ObservableWithParamUseCase<Response<Unit>, SendMessageRequest>(
        threadExecuter,
        AndroidSchedulers.mainThread()
    ) {
    override fun build(request : SendMessageRequest): Observable<Response<Unit>> {
        return cvApiService.postSendMessage(request)
    }
}