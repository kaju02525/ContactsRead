package com.popwoot.contact

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.popwoot.library.Contact
import com.popwoot.library.RxContacts
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private val compositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestContacts()
    }


    private fun requestContacts() {
        compositeDisposable.add(
            RxContacts.fetch(this)
                .filter { m -> m.inVisibleGroup == 1 }
                .toSortedList { obj, other -> obj.compareTo(other) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ contacts ->
                    getContactsList(contacts)
                }, { it ->
                    //Handle exception
                })
        )
    }

    private fun getContactsList(contacts: MutableList<Contact>) {
        contacts.forEach {
            Log.d("TAGS", " ${it.displayName}")
            Log.d("TAGS", " ${it.phoneNumbers}")
            val photoUri = it.thumbnail
            Log.d("TAGS", " $photoUri")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}