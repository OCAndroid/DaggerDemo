package org.ocandroid.di.application

import android.app.Application
import org.ocandroid.di.dagger.component.ApplicationComponent
import org.ocandroid.di.dagger.component.DaggerApplicationComponent
import org.ocandroid.di.util.Logger

class DIApplication : Application() {

    private lateinit var logger: Logger

    lateinit var applicationComponent: ApplicationComponent
        private set

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .withContext(this)
            .build()
        logger = applicationComponent.exposeLogger()
        logger.logMessage(message = "onCreate called")
    }
}