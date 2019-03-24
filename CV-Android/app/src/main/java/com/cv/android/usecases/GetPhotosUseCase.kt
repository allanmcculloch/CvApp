package com.cv.android.usecases

import com.cv.android.repository.PhotosRepository
import com.cv.models.Photo
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetPhotosUseCase(private val repository: PhotosRepository, threadExecuter: Scheduler = Schedulers.io()) :
    ObservableWithoutParamUseCase<List<Photo>>(
        threadExecuter,
        AndroidSchedulers.mainThread()
    ) {
    override fun build(): Observable<List<Photo>> {
        return repository.getPhotos()
    }
}