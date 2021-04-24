package org.ocandroid.di.dagger

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import dagger.MapKey
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.reflect.KClass

// Scopes

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ApplicationScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthedScope

// Qualifiers

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Uuid

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserId

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UserName

// Multibinding Keys

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)
