package org.ocandroid.di.list.presentation

import androidx.lifecycle.ViewModel
import org.ocandroid.di.list.model.repository.ItemRepository
import javax.inject.Inject

class ItemListViewModel @Inject constructor(
    private val itemRepository: ItemRepository
) : ViewModel()  {

    fun getItems() = itemRepository.getItems()
}