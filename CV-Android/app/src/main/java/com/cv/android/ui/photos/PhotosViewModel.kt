package com.cv.android.ui.photos

import androidx.lifecycle.ViewModel
import com.cv.android.usecases.GetPhotosUseCase
import com.cv.models.Photo

import io.reactivex.disposables.Disposable

class PhotosViewModel(private val getPhotosUseCase: GetPhotosUseCase) : ViewModel() {
    val photosAdaptor: PhotosAdapter = PhotosAdapter()
    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {
        subscription = getPhotosUseCase.execute()
            .subscribe({
                onFetchedList(it)
            },Throwable::printStackTrace)
    }

    private fun onFetchedList(photos : List<Photo>) {
        photosAdaptor.updateList(photos)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
