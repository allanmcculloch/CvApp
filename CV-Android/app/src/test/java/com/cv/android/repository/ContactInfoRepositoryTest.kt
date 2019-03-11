package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.ContactInfo
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before


class ContactInfoRepositoryTest {

    private lateinit var cvApiServiceMock: CvApiService
    private lateinit var contactInfoRepository : ContactInfoRepository

    @Before
    fun setup() {
        cvApiServiceMock = mockk(relaxed = true)
        contactInfoRepository = ContactInfoRepository(cvApiServiceMock)
    }

    @Test
    fun when_emptycache_callapi_returnsApiData() {

        val apiContactInfo = ContactInfo("John Smith")

        every { cvApiServiceMock.getContactInfo() }.returns(Observable.just(apiContactInfo))

        val contactInfoReturned = contactInfoRepository.getContactInfo()

        contactInfoReturned.test().assertValue { it == apiContactInfo}
    }

    @Test
    fun when_hasCache_returnsCache_thenApi() {

        val cachedContactInfo = ContactInfo("Mr Cached")
        val apiContactInfo = ContactInfo("Mr Api")

        contactInfoRepository.cache = cachedContactInfo

        every { cvApiServiceMock.getContactInfo() }.returns(Observable.just(apiContactInfo))

        val contactInfoReturned = contactInfoRepository.getContactInfo()

        contactInfoReturned.test().assertValueAt(0) { it == cachedContactInfo}
        contactInfoReturned.test().assertValueAt(1) { it == apiContactInfo}
    }

    @Test
    fun when_nocache_updatesCacheFromApi() {

        val apiContactInfo = ContactInfo("Mr Api")

        contactInfoRepository.cache = null

        every { cvApiServiceMock.getContactInfo() }.returns(Observable.just(apiContactInfo))

        val contactInfoReturned = contactInfoRepository.getContactInfo()

        contactInfoReturned.test().assertValueAt(0) { it == apiContactInfo}

        assertEquals(contactInfoRepository.cache, apiContactInfo)
    }
}
