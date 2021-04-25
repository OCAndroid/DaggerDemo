package org.ocandroid.di.dagger.module

import androidx.fragment.app.FragmentFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import org.ocandroid.di.dagger.component.AuthedComponent
import org.ocandroid.di.factory.DIFragmentFactory

@InstallIn(ActivityComponent::class)
@Module
abstract class AuthedFactoryModule {

    @Binds
    abstract fun bindFragmentFactory(diFragmentFactory: DIFragmentFactory): FragmentFactory
}