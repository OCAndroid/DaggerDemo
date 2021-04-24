package org.ocandroid.di.detail.model.repository

import org.ocandroid.di.detail.model.ItemDetails
import org.ocandroid.di.util.Logger
import javax.inject.Inject

class ItemDetailRepository @Inject constructor(
    private val logger: Logger
) {

    fun getDetails(id: String): ItemDetails {
        val details = makeDetails(Integer.parseInt(id))
        logger.logMessage(this.javaClass.simpleName, "Fetched item: $id - $details")
        return ItemDetails(id, details)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }
}