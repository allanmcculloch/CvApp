package com.cv.android.ui.joblist

import androidx.lifecycle.ViewModel
import com.cv.android.repository.JobsRepository
import com.cv.models.Job

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class JobListViewModel(private val repository: JobsRepository) : ViewModel() {


    val jobListAdapter: JobListAdapter = JobListAdapter()

    private lateinit var subscription: Disposable

    init {
        loadData()
    }

    private fun loadData() {

        subscription = repository.getJobs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                onFetchedList(it)

            },Throwable::printStackTrace)
    }

    private fun onFetchedList(jobList : List<Job>) {

        jobListAdapter.updateList(jobList)

    }

    override fun onCleared() {
        super.onCleared()
        subscription?.dispose()
    }
}
