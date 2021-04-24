package org.ocandroid.di.dagger.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import org.ocandroid.di.factory.DIViewModelFactory

@Module
abstract class FactoryModule {

    @Binds
    abstract fun bindViewModelFactory(diViewModelFactory: DIViewModelFactory): ViewModelProvider.Factory
}