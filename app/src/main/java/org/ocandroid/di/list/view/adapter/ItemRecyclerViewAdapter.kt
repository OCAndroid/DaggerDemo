package org.ocandroid.di.list.view.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import org.ocandroid.di.databinding.FragmentItemBinding
import org.ocandroid.di.list.model.Item
class ItemRecyclerViewAdapter(
    private val itemClicked: (Item) -> Unit
) : RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder>() {

    private var items: List<Item> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(items: List<Item>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            FragmentItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.idView.text = item.id
        holder.contentView.apply {
            text = item.content
            setOnClickListener {
                itemClicked(item)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(binding: FragmentItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.itemNumber
        val contentView: TextView = binding.content

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}