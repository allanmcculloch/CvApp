package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.Job
import io.reactivex.Observable

class JobsRepository(private val cvApiService : CvApiService) {
    var cache : List<Job> = listOf()

    fun getJobs() : Observable<List<Job>> {
        if (cache.isEmpty()) {
            return cvApiService.getJobs()
                .doOnNext { cache = it }
        }
        else {
            return Observable.just(cache)
                .mergeWith(cvApiService.getJobs())
                .doOnNext { cache = it  }
        }
    }
}