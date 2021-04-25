package org.ocandroid.di.list.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.ocandroid.di.list.model.repository.ItemRepository
import javax.inject.Inject

@HiltViewModel
class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel()  {

    fun getItems() = itemRepository.getItems()
}