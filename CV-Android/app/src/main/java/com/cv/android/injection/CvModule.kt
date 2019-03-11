package com.cv.android.injection

import com.cv.android.network.ClientProvider
import com.cv.android.repository.ContactInfoRepository
import com.cv.android.repository.JobsRepository
import com.cv.android.repository.remote.CvApiService
import com.cv.android.ui.ContactInfoViewModel
import com.cv.android.ui.JobListViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val cvModule = module {

    viewModel { ContactInfoViewModel(get()) }
    viewModel { JobListViewModel(get()) }

    single { ContactInfoRepository(get()) }
    single { JobsRepository(get()) }
    single { CvApiService(get()) }
    single { ClientProvider() }

}