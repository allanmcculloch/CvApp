package com.cv.android.ui.photos

import androidx.lifecycle.MutableLiveData
import com.cv.models.Photo

class PhotoViewModel {

    val title : MutableLiveData<String> = MutableLiveData()
    val imageUrl : MutableLiveData<String> = MutableLiveData()

    fun bind(photo : Photo) {

        title.value = photo.title
        imageUrl.value = photo.imageUrl
    }
}
