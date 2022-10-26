package com.example.testcleanarchitecture.di

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecturedomain.domain.usecase.SaveUserNameUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn (ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetUserNameUseCase(userRepository: UserRepository): GetUserNameUseCase{
        return GetUserNameUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserNameUseCase(repository: UserRepository): SaveUserNameUseCase {
        return SaveUserNameUseCase(repository)
    }

}