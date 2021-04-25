package org.ocandroid.di.detail.presentation

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.ocandroid.di.detail.model.repository.ItemDetailRepository
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val detailsRepository: ItemDetailRepository
) : ViewModel() {

    fun getItemDetails(id: String) = detailsRepository.getDetails(id)
}