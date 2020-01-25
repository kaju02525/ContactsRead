# Contacts Read
Android library to get contacts using RxJava2 and kotlin

[![](https://jitpack.io/v/kaju02525/ContactsRead.svg)](https://jitpack.io/#kaju02525/ContactsRead)


# Usage
First add jitpack to your projects build.gradle file
```gradle.class
repositories {
    maven { url 'https://jitpack.io' }
}
```

Then add the dependency in modules build.gradle file
```gradle.app
dependencies {
    implementation 'com.github.kaju02525:ContactsRead:1.0.0'
}
```

# Example

```kotlin
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
```

```
 private fun getContactsList(contacts: MutableList<Contact>) {
        contacts.forEach {
            Log.d("TAGS", " ${it.displayName}")
            Log.d("TAGS", " ${it.phoneNumbers}")
            val photoUri = it.thumbnail
            Log.d("TAGS", " $photoUri")
        }
    }
    
```
