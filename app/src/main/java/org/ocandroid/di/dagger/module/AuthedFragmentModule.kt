package org.ocandroid.di.dagger.module

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import org.ocandroid.di.dagger.FragmentKey
import org.ocandroid.di.detail.view.ItemDetailFragment
import org.ocandroid.di.list.view.ItemListFragment

@Module
abstract class AuthedFragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ItemListFragment::class)
    abstract fun bindItemListFragment(itemListFragment: ItemListFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ItemDetailFragment::class)
    abstract fun bindItemDetailFragment(itemDetailFragment: ItemDetailFragment): Fragment

}