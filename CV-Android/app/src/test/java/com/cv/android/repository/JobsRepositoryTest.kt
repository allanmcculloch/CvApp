package com.cv.android.repository

import com.cv.android.repository.remote.CvApiService
import com.cv.models.Job
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class JobsRepositoryTest {

    private lateinit var cvApiServiceMock: CvApiService
    private lateinit var jobsRepository : JobsRepository

    @Before
    fun setup() {
        cvApiServiceMock = mockk(relaxed = true)
        jobsRepository = JobsRepository(cvApiServiceMock)
    }

    @Test
    fun when_emptycache_callapi_returnsApiData() {

        every { cvApiServiceMock.getJobs() }.returns(Observable.just(sampleDataApi))

        val jobsReturned = jobsRepository.getJobs()

        jobsReturned.test().assertValue { it == sampleDataApi }
    }

    @Test
    fun when_hasCache_returnsCache_thenApi() {

        every { cvApiServiceMock.getJobs() }.returns(Observable.just(sampleDataApi))

        jobsRepository.cache = sampleDataInCache

        val jobsReturned = jobsRepository.getJobs()

        jobsReturned.test().assertValueAt(0) { it == sampleDataInCache}
        jobsReturned.test().assertValueAt(1) { it == sampleDataApi}
    }

    @Test
    fun when_nocache_updatesCacheFromApi() {

        jobsRepository.cache = null

        every { cvApiServiceMock.getJobs() }.returns(Observable.just(sampleDataApi))

        val jobsReturned = jobsRepository.getJobs()

        jobsReturned.test().assertValueAt(0) { it == sampleDataApi}

        assertEquals(jobsRepository.cache, sampleDataApi)
    }

    val sampleDataApi =

        listOf(
            Job("Company1", "Title1","Description1","period1","location1"),
            Job("Company2", "Title2","Description2","period2","location2"),
            Job("Company3", "Title3","Description3","period3","location3")
        )

    val sampleDataInCache =
        listOf(
            Job("Company4", "Title4","Description4","period4","location6"),
            Job("Company5", "Title5","Description5","period5","location6")
        )
}
