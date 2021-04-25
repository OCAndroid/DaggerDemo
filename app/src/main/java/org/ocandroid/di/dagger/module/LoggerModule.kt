package org.ocandroid.di.dagger.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.ocandroid.di.dagger.Uuid
import org.ocandroid.di.util.Logger
import java.util.*
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LoggerModule {

    @Singleton
    @Provides
    @Uuid
    fun provideUuid(): String = UUID.randomUUID().toString()

    @Singleton
    @Provides
    fun provideLogger(@Uuid uuid: String) = Logger(uuid)
}