package org.ocandroid.di.list.model.repository

import org.ocandroid.di.list.model.Item
import org.ocandroid.di.util.Logger
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val logger: Logger
) {

    fun getItems(): List<Item> {
        val items: MutableList<Item> = ArrayList()
        for (position in 1..25) {
            items.add(Item(position.toString(), "Item $position"))
        }
        logger.logMessage(this.javaClass.simpleName, "Fetched ${items.size} items")
        return items
    }
}