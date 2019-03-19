package com.cv.android.ui.photos

import com.cv.android.ui.BaseViewModelTest
import com.cv.models.Photo
import com.jraska.livedata.test
import org.junit.Test

class PhotoViewModelTest : BaseViewModelTest() {
    @Test
    fun testReturnsCorrectValues() {

        val viewModel = createViewModel()

        viewModel.bind(photoTestData)

        viewModel.title.test().assertValue(photoTestData.title)
        viewModel.imageUrl.test().assertValue(photoTestData.imageUrl)
    }

    fun createViewModel() = PhotoViewModel()

    val photoTestData = Photo("test1", "http://www.someurl.comm/image1.png")
}