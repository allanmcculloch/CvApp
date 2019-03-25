package com.cv.android.ui.photos

import com.cv.android.ui.BaseViewModelTest
import com.cv.android.usecases.GetPhotosUseCase
import com.cv.models.Photo
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhotosViewModelTest : BaseViewModelTest() {
    lateinit var viewModel : PhotosViewModel
    lateinit var getPhotosUseCase : GetPhotosUseCase

    @Before
    fun setUp() {
        getPhotosUseCase = mockk(relaxed = true)

        every {getPhotosUseCase.execute() }.returns(Observable.just(sampleData))
    }

    @Test
    fun retunsCorrectNumberOfRows() {

        viewModel = createViewModel()

        assertEquals(viewModel.photosAdaptor.itemCount, sampleData.count())
    }

    private fun createViewModel() = PhotosViewModel(getPhotosUseCase)

    private val sampleData =

        listOf(
            Photo("Test1", "http://someUrl.com/image1.png"),
            Photo("Test2", "http://someUrl.com/image2.png")
        )
}
