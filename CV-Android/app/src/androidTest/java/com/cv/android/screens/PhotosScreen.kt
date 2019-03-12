package com.cv.android.screens

import com.cv.android.R

internal class PhotosScreen {

    private val photosList = R.id.photosRecyclerView

    fun checkPositionHasText(text : String, position : Int) {
        checkTextOnRecycler(photosList, text, position)
    }
}