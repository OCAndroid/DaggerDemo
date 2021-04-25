package org.ocandroid.di.dagger.component

import dagger.BindsInstance
import dagger.hilt.DefineComponent
import org.ocandroid.di.dagger.UserId
import org.ocandroid.di.dagger.UserName
import dagger.hilt.InstallIn
import dagger.hilt.EntryPoint
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
interface AuthedComponent {

    @DefineComponent.Builder
    interface Builder {
        @BindsInstance
        fun userId(@UserId userId: String): Builder

        @BindsInstance
        fun userName(@UserName userName: String): Builder

        fun build(): AuthedComponent
    }
}

@EntryPoint
@InstallIn(AuthedComponent::class)
interface AuthedEntryPoint {
    @UserId fun getUserId(): String
    @UserName fun getUserName(): String
}