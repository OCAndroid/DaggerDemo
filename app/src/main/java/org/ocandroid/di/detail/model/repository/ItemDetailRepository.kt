package org.ocandroid.di.detail.model.repository

import dagger.hilt.EntryPoints
import org.ocandroid.di.dagger.component.AuthedComponentHandler
import org.ocandroid.di.dagger.component.AuthedEntryPoint
import org.ocandroid.di.detail.model.ItemDetails
import org.ocandroid.di.util.Logger
import javax.inject.Inject

class ItemDetailRepository @Inject constructor(
    private val logger: Logger,
    private val authedComponentHandler: AuthedComponentHandler
) {

    fun getDetails(id: String): ItemDetails {
        val details = makeDetails(Integer.parseInt(id))
        logger.logMessage(this.javaClass.simpleName, "Fetched item: $id - $details")
        return ItemDetails(id, details)
    }

    private fun makeDetails(position: Int): String {
        val authedEntryPoint = EntryPoints.get(authedComponentHandler.generatedComponent(), AuthedEntryPoint::class.java)
        val builder = StringBuilder()
        builder.append("Details about Item: $position for ${authedEntryPoint.getUserName()}")
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        builder.append("\nUser id: ${authedEntryPoint.getUserId()}")
        return builder.toString()
    }
}