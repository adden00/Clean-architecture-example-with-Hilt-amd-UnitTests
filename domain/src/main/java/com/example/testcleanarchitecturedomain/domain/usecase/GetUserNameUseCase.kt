package com.example.testcleanarchitecture.domain.usecase

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.UserName

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getName()
    }
}