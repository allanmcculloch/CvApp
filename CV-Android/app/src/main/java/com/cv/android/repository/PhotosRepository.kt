package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.Photo
import io.reactivex.Observable

class PhotosRepository(private val cvApiService : CvApiService) {

    var cache : List<Photo> = listOf()

    fun getPhotos() : Observable<List<Photo>> {
        if (cache.isEmpty()) {
            return cvApiService.getPhotos()
                .doOnNext { cache = it }
        }
        else {
            return Observable.just(cache)
                .mergeWith(cvApiService.getPhotos())
                .doOnNext { cache = it  }
        }
    }
}