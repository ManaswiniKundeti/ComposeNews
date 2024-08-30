package com.example.composenews.data.manager

import android.content.Context
import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.composenews.domain.manager.LocalUserManager
import com.example.composenews.util.Constants
import com.example.composenews.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * DataStore Preferences is a jetpack library that allows us to save key values locally in device
 * https://developer.android.com/topic/libraries/architecture/datastore
 */
class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager{
    override suspend fun saveAppEntry() {
        Log.d("LocalUserManagerImpl", "Saving app entry as true")
       context.dataStore.edit { settings ->
           settings[PreferencesKeys.APP_ENTRY] = true
       }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }
}

// Define this data store only once and access it in other places as needed as a Singleton
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS )

private object PreferencesKeys {
    val APP_ENTRY = booleanPreferencesKey(name = Constants.APP_ENTRY)
}