package com.popwoot.library


import android.database.Cursor
import android.net.Uri


internal object ColumnMapper {

    fun mapInVisibleGroup(cursor: Cursor, contact: Contact, columnIndex: Int) {
        contact.inVisibleGroup = cursor.getInt(columnIndex)
    }

    fun mapDisplayName(cursor: Cursor, contact: Contact, columnIndex: Int) {
        val displayName = cursor.getString(columnIndex)
        if (displayName != null && !displayName.isEmpty()) {
            contact.displayName = displayName
        }
    }

    fun mapEmail(cursor: Cursor, contact: Contact, columnIndex: Int) {
        val email = cursor.getString(columnIndex)
        if (email != null && !email.isEmpty()) {
            contact.emails.add(email)
        }
    }

    fun mapPhoneNumber(cursor: Cursor, contact: Contact, columnIndex: Int) {
        var phoneNumber: String? = cursor.getString(columnIndex)
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            // Remove all whitespaces
            phoneNumber = phoneNumber.replace("\\s+".toRegex(), "")
            contact.phoneNumbers.add(phoneNumber)
        }
    }

    fun mapPhoto(cursor: Cursor, contact: Contact, columnIndex: Int) {
        val uri = cursor.getString(columnIndex)
        if (uri != null && !uri.isEmpty()) {
            contact.photo = Uri.parse(uri)
        }
    }

    fun mapStarred(cursor: Cursor, contact: Contact, columnIndex: Int) {
        contact.isStarred = cursor.getInt(columnIndex) != 0
    }

    fun mapThumbnail(cursor: Cursor, contact: Contact, columnIndex: Int) {
        val uri = cursor.getString(columnIndex)
        if (uri != null && !uri.isEmpty()) {
            contact.thumbnail = Uri.parse(uri)
        }
    }
}// Utility class -> No instances allowed
