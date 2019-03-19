package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.ContactInfo
import io.reactivex.Observable

class ContactInfoRepository(private val cvApiService : CvApiService) {
    var cache : ContactInfo? = null

    fun getContactInfo() : Observable<ContactInfo?> {
        if (cache == null) {
            return cvApiService.getContactInfo()
                .doOnNext { cache = it }
        }
        else {
            return Observable.just(cache)
                .mergeWith(cvApiService.getContactInfo())
                .doOnNext { cache = it  }
        }
    }
}