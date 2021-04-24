package org.ocandroid.di.dagger.module

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.ocandroid.di.dagger.ViewModelKey
import org.ocandroid.di.detail.presentation.ItemDetailViewModel
import org.ocandroid.di.list.presentation.ItemListViewModel

@Module
abstract class AuthedViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ItemDetailViewModel::class)
    abstract fun bindItemDetailViewModel(itemDetailViewModel: ItemDetailViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ItemListViewModel::class)
    abstract fun bindItemListViewModel(itemListViewModel: ItemListViewModel): ViewModel
}