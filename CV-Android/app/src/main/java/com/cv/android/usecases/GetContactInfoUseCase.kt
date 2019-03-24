package com.cv.android.usecases

import com.cv.android.repository.ContactInfoRepository
import com.cv.models.ContactInfo
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetContactInfoUseCase(
    private val repository: ContactInfoRepository,
    threadExecuter: Scheduler = Schedulers.io()
) :
    ObservableWithoutParamUseCase<ContactInfo?>(
        threadExecuter,
        AndroidSchedulers.mainThread()
    ) {
    override fun build(): Observable<ContactInfo?> {
        return repository.getContactInfo()
    }
}