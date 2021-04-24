package org.ocandroid.di.detail.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import org.ocandroid.di.databinding.ItemDetailFragmentBinding
import org.ocandroid.di.detail.presentation.ItemDetailViewModel
import org.ocandroid.di.util.Logger
import javax.inject.Inject

private const val ARG_ID_KEY = "id_key"
private const val ARG_CONTENT_KEY = "content_key"

class ItemDetailFragment @Inject constructor(
    private val logger: Logger,
    private val vmFactory: ViewModelProvider.Factory
) : Fragment() {

    private var binding: ItemDetailFragmentBinding? = null
    private lateinit var viewModel: ItemDetailViewModel
    private lateinit var itemId: String
    private lateinit var itemContent: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, vmFactory).get(ItemDetailViewModel::class.java)

        arguments?.apply {
            itemId = getString(ARG_ID_KEY, "")
            itemContent = getString(ARG_CONTENT_KEY, "")
        }

        logger.logMessage(this.javaClass.simpleName, "$itemId - $itemContent")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = ItemDetailFragmentBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            itemTitle.text = itemContent
            itemDetails.text = viewModel.getItemDetails(itemId).details
        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    companion object {
        fun createArguments(id: String, content: String): Bundle = bundleOf(
            Pair(ARG_ID_KEY, id),
            Pair(ARG_CONTENT_KEY, content),
        )
    }
}