package com.popwoot.library

import android.net.Uri

import java.util.HashSet


class Contact internal constructor(val id: Long) : Comparable<Contact> {
    var inVisibleGroup: Int = 0
    var displayName: String? = null
    var isStarred: Boolean = false
    var photo: Uri? = null
    var thumbnail: Uri? = null
    var emails= HashSet<String>()
    var phoneNumbers = HashSet<String>()


    override fun compareTo(other: Contact): Int {
        return if (displayName != null && other.displayName != null) {
            displayName!!.compareTo(other.displayName!!)
        } else -1

    }

    override fun hashCode(): Int {
        return (id xor id.ushr(32)).toInt()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other == null || javaClass != other.javaClass) {
            return false
        }
        val contact = other as Contact?
        return id == contact!!.id
    }
}
