package org.ocandroid.di.dagger.module

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import org.ocandroid.di.factory.DIFragmentFactory

@Module
abstract class AuthedFactoryModule {

    @Binds
    abstract fun bindFragmentFactory(diFragmentFactory: DIFragmentFactory): FragmentFactory
}