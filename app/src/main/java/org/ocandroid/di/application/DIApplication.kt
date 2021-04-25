package org.ocandroid.di.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import org.ocandroid.di.util.Logger
import javax.inject.Inject

@HiltAndroidApp
class DIApplication : Application() {

    @Inject lateinit var logger: Logger

    /*lateinit var applicationComponent: ApplicationComponent
        private set*/

    override fun onCreate() {
        super.onCreate()
        /*applicationComponent = DaggerApplicationComponent.builder()
            .withContext(this)
            .build()
        logger = applicationComponent.exposeLogger()*/
        logger.logMessage(message = "onCreate called")
    }
}