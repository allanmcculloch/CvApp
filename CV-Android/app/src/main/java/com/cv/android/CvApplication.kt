package com.cv.android

import android.app.Application
import com.cv.android.injection.cvModule
import org.koin.android.ext.android.startKoin

class CvApplication : Application() {
    override fun onCreate(){
        super.onCreate()

        val modules = listOf(cvModule)

        startKoin(this, modules)
    }
}