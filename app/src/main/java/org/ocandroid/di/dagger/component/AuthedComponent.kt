package org.ocandroid.di.dagger.component

import dagger.BindsInstance
import dagger.Subcomponent
import org.ocandroid.di.auth.view.AuthedActivity
import org.ocandroid.di.dagger.AuthedScope
import org.ocandroid.di.dagger.UserId
import org.ocandroid.di.dagger.UserName
import org.ocandroid.di.dagger.module.AuthedFactoryModule
import org.ocandroid.di.dagger.module.AuthedFragmentModule
import org.ocandroid.di.dagger.module.AuthedViewModelModule

@AuthedScope
@Subcomponent(modules = [
    AuthedViewModelModule::class,
    AuthedFactoryModule::class,
    AuthedFragmentModule::class
])
interface AuthedComponent {

    fun inject(authedActivity: AuthedActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun userId(@UserId userId: String): Builder

        @BindsInstance
        fun userName(@UserName userName: String): Builder

        fun build(): AuthedComponent
    }
}