package com.cv.android.ui.photos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cv.models.Photo

class PhotoViewModel {
    private val _title : MutableLiveData<String> = MutableLiveData()
    private val _imageUrl : MutableLiveData<String> = MutableLiveData()

    val title: LiveData<String> = _title
    val imageUrl: LiveData<String> = _imageUrl

    fun bind(photo : Photo) {

        _title.value = photo.title
        _imageUrl.value = photo.imageUrl
    }
}
