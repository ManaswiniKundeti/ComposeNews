package com.example.composenews.domain.usecases.appEntry

import com.example.composenews.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}