package com.example.testcleanarchitecture.di

import android.content.Context
import com.example.testcleanarchitecture.data.repository.UserRepositoryImpl
import com.example.testcleanarchitecture.data.storage.UserStorage
import com.example.testcleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.example.testcleanarchitecture.domain.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideUserStorage(@ApplicationContext context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    @Singleton
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}