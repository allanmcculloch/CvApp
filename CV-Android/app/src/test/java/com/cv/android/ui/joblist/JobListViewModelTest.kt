package com.cv.android.ui.joblist

import com.cv.android.ui.BaseViewModelTest
import com.cv.android.usecases.GetJobsListUseCase
import com.cv.models.Job
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class JobListViewModelTest : BaseViewModelTest() {
    lateinit var viewModel : JobListViewModel
    lateinit var getJobsListUseCase : GetJobsListUseCase

    @Before
    fun setUp() {
        getJobsListUseCase = mockk(relaxed = true)

        every {getJobsListUseCase.execute() }.returns(Observable.just(sampleData))
    }

    @Test
    fun returnsCorrectNumberOfRows() {
        viewModel = createViewModel()

        assertEquals(viewModel.jobListAdapter.itemCount, sampleData.count())
    }

    private fun createViewModel() = JobListViewModel(getJobsListUseCase)

    private val sampleData =
        listOf(
            Job("Company1", "Title1","Description1","period1","location1","http://someUrl.com/image1.png"),
            Job("Company2", "Title2","Description2","period2","location2","http://someUrl.com/image2.png"))
}
