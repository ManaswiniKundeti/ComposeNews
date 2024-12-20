package com.example.composenews.domain.usecases.appEntry

import com.example.composenews.data.dataStore.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}