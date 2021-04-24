package org.ocandroid.di.dagger.module

import dagger.Module
import dagger.Provides
import org.ocandroid.di.dagger.ApplicationScope
import org.ocandroid.di.dagger.Uuid
import org.ocandroid.di.util.Logger
import java.util.*

@Module
class LoggerModule {

    @ApplicationScope
    @Provides
    @Uuid
    fun provideUuid(): String = UUID.randomUUID().toString()

    @ApplicationScope
    @Provides
    fun provideLogger(@Uuid uuid: String) = Logger(uuid)
}