package org.ocandroid.di.detail.model.repository

import org.ocandroid.di.dagger.UserId
import org.ocandroid.di.dagger.UserName
import org.ocandroid.di.detail.model.ItemDetails
import org.ocandroid.di.util.Logger
import javax.inject.Inject

class ItemDetailRepository @Inject constructor(
    private val logger: Logger,
    @UserId private val userId: String,
    @UserName private val userName: String
) {

    fun getDetails(id: String): ItemDetails {
        val details = makeDetails(Integer.parseInt(id))
        logger.logMessage(this.javaClass.simpleName, "Fetched item: $id - $details")
        return ItemDetails(id, details)
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: $position for $userName")
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        builder.append("\nUser id: $userId")
        return builder.toString()
    }
}