package org.ocandroid.di.dagger.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import org.ocandroid.di.dagger.ApplicationScope
import org.ocandroid.di.dagger.module.FactoryModule
import org.ocandroid.di.dagger.module.LoggerModule
import org.ocandroid.di.dagger.module.ViewModelModule
import org.ocandroid.di.login.view.LoginActivity
import org.ocandroid.di.util.Logger

@ApplicationScope
@Component(modules = [
    LoggerModule::class,
    FactoryModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(loginActivity: LoginActivity)

    fun authedSubcomponent(): AuthedComponent.Builder

    fun exposeLogger(): Logger

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        fun build(): ApplicationComponent
    }
}