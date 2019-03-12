package com.cv.android.ui

import com.cv.android.ui.joblist.JobViewModel
import com.cv.models.Job
import com.jraska.livedata.test
import org.junit.Test

class JobViewModelTest : BaseViewModelTest() {

    @Test
    fun testReturnsCorrectValues() {

        val viewModel = createViewModel()

        viewModel.bind(jobTestData)

        viewModel.company.test().assertValue(jobTestData.company)
        viewModel.title.test().assertValue(jobTestData.title)
        viewModel.description.test().assertValue(jobTestData.description)
        viewModel.period.test().assertValue(jobTestData.period)
        viewModel.location.test().assertValue(jobTestData.location)
    }

    fun createViewModel() = JobViewModel()


    val jobTestData = Job("Company","Title","Description1","Period1","Location1")
}