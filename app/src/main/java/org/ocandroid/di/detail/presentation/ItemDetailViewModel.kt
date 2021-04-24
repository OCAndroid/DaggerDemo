package org.ocandroid.di.detail.presentation

import androidx.lifecycle.ViewModel
import org.ocandroid.di.detail.model.repository.ItemDetailRepository
import javax.inject.Inject

class ItemDetailViewModel @Inject constructor(
    private val detailsRepository: ItemDetailRepository
) : ViewModel() {

    fun getItemDetails(id: String) = detailsRepository.getDetails(id)
}