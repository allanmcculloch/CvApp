package com.cv.android.injection

import com.cv.android.network.ClientProvider
import com.cv.android.repository.ContactInfoRepository
import com.cv.android.repository.JobsRepository
import com.cv.android.repository.PhotosRepository
import com.cv.android.repository.remote.CvApiService
import com.cv.android.ui.contactinfo.ContactInfoViewModel
import com.cv.android.ui.joblist.JobListViewModel
import com.cv.android.ui.photos.PhotosViewModel
import com.cv.android.ui.sendmessage.SendMessageViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val cvModule = module {

    viewModel { ContactInfoViewModel(get()) }
    viewModel { JobListViewModel(get()) }
    viewModel { SendMessageViewModel(get()) }
    viewModel { PhotosViewModel(get()) }

    single { ContactInfoRepository(get()) }
    single { JobsRepository(get()) }
    single { PhotosRepository(get()) }

    single { CvApiService(get()) }
    single { ClientProvider() }
}