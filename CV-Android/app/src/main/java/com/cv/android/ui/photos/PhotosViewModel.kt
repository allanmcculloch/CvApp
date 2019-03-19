package com.cv.android.ui.photos

import androidx.lifecycle.ViewModel
import com.cv.android.repository.PhotosRepository
import com.cv.models.Photo

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PhotosViewModel(private val repository: PhotosRepository) : ViewModel() {
    val photosAdaptor: PhotosAdapter = PhotosAdapter()
    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {
        subscription = repository.getPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                onFetchedList(it)

            },Throwable::printStackTrace)
    }

    private fun onFetchedList(jobList : List<Photo>) {
        photosAdaptor.updateList(jobList)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
