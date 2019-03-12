package com.cv.android.ui.photos


import com.cv.android.repository.PhotosRepository
import com.cv.android.ui.BaseViewModelTest
import com.cv.models.Photo
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhotosViewModelTest : BaseViewModelTest() {

    lateinit var viewModel : PhotosViewModel
    lateinit var photosRepository : PhotosRepository

    @Before
    fun setUp() {

        photosRepository = mockk(relaxed = true)

        every {photosRepository.getPhotos() }.returns(Observable.just(sampleData))
    }

    @Test
    fun retunsCorrectNumberOfRows() {

        viewModel = createViewModel()

        assertEquals(viewModel.photosAdaptor.itemCount, sampleData.count())
    }

    fun createViewModel() = PhotosViewModel(photosRepository)

    val sampleData =

        listOf(
            Photo("Test1", "http://someUrl.com/image1.png"),
            Photo("Test2", "http://someUrl.com/image2.png")
        )
}
