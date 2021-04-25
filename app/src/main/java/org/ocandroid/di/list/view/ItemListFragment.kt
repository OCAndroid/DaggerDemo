package org.ocandroid.di.list.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import org.ocandroid.di.auth.view.AuthedActivity
import org.ocandroid.di.databinding.FragmentItemListBinding
import org.ocandroid.di.list.presentation.ItemListViewModel
import org.ocandroid.di.list.view.adapter.ItemRecyclerViewAdapter
import org.ocandroid.di.util.Logger
import javax.inject.Inject

@AndroidEntryPoint
class ItemListFragment @Inject constructor(
    private val logger: Logger,
) : Fragment() {

    private lateinit var viewModel: ItemListViewModel
    private var binding: FragmentItemListBinding? = null
    private val itemAdapter = ItemRecyclerViewAdapter { item ->
        (activity as? AuthedActivity)?.navigateToDetails(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ItemListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.list?.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(context)
        }

        val items = viewModel.getItems()
        logger.logMessage(this.javaClass.simpleName, "Item count: ${items.size}")
        itemAdapter.setItems(items)
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}