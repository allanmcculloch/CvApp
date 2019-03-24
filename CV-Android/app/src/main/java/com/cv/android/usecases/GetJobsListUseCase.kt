package com.cv.android.usecases

import com.cv.android.repository.JobsRepository
import com.cv.models.Job
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class GetJobsListUseCase(private val repository: JobsRepository, threadExecuter: Scheduler = Schedulers.io()) :
    ObservableWithoutParamUseCase<List<Job>>(
        threadExecuter,
        AndroidSchedulers.mainThread()
    ) {
    override fun build(): Observable<List<Job>> {
        return repository.getJobs()
    }
}