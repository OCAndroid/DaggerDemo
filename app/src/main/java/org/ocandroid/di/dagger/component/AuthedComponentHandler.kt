package org.ocandroid.di.dagger.component

import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthedComponentHandler @Inject constructor(
    private val authedComponentBuilder: AuthedComponent.Builder
): GeneratedComponentManager<AuthedComponent> {

    private lateinit var authedComponent: AuthedComponent

    fun auth(userName: String, userId: String) {
        authedComponent = authedComponentBuilder
            .userId(userId)
            .userName(userName)
            .build()
    }

    override fun generatedComponent(): AuthedComponent = authedComponent
}