package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.Photo
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class PhotosRepositoryTest {
    private lateinit var cvApiServiceMock: CvApiService
    private lateinit var photosRepository : PhotosRepository

    @Before
    fun setup() {
        cvApiServiceMock = mockk(relaxed = true)
        photosRepository = PhotosRepository(cvApiServiceMock)
    }

    @Test
    fun when_emptycache_callapi_returnsApiData() {
        every { cvApiServiceMock.getPhotos() }.returns(Observable.just(sampleDataApi))

        val photosReturned = photosRepository.getPhotos()

        photosReturned.test().assertValue { it == sampleDataApi }
    }

    @Test
    fun when_hasCache_returnsCache_thenApi() {
        every { cvApiServiceMock.getPhotos() }.returns(Observable.just(sampleDataApi))

        photosRepository.cache = sampleDataInCache

        val photosReturned = photosRepository.getPhotos()

        photosReturned.test().assertValueAt(0) { it == sampleDataInCache}
        photosReturned.test().assertValueAt(1) { it == sampleDataApi}
    }

    @Test
    fun when_nocache_updatesCacheFromApi() {
        photosRepository.cache = listOf()

        every { cvApiServiceMock.getPhotos() }.returns(Observable.just(sampleDataApi))

        val photosReturned = photosRepository.getPhotos()

        photosReturned.test().assertValueAt(0) { it == sampleDataApi}

        assertEquals(photosRepository.cache, sampleDataApi)
    }

    val sampleDataApi =
        listOf(
            Photo("Test1","http://www.someurl.com/photo1.png"),
            Photo("Test2","http://www.someurl.com/photo2.png")

        )

    val sampleDataInCache =
        listOf(
            Photo("Test3","http://www.someurl.com/photo3.png")
        )
}
