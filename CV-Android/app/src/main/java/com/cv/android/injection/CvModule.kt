package com.cv.android.injection

import com.cv.android.network.ClientProvider
import com.cv.android.repository.CvRepository
import com.cv.android.repository.remote.CvApiService
import com.cv.android.ui.ContactInfoViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val cvModule = module {

    viewModel { ContactInfoViewModel(get()) }
    single { CvRepository(get()) }
    single { CvApiService(get()) }
    single { ClientProvider() }

}