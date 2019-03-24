package com.cv.android.ui.joblist

import androidx.lifecycle.ViewModel
import com.cv.android.usecases.GetJobsListUseCase
import com.cv.models.Job
import io.reactivex.disposables.Disposable

class JobListViewModel(private val getJobsListUseCase: GetJobsListUseCase) : ViewModel() {
    val jobListAdapter: JobListAdapter = JobListAdapter()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {
        subscription = getJobsListUseCase
            .execute()
            .subscribe({
            onFetchedList(it)
        }, Throwable::printStackTrace)
    }

    private fun onFetchedList(jobList : List<Job>) {
        jobListAdapter.updateList(jobList)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}
