package com.example.testcleanarchitecturedomain.domain.usecase

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase(private val userRepository: UserRepository) {
    fun execute(param: SaveUserNameParam): Boolean {

        val oldName = userRepository.getName()
        if (oldName.firstName == param.name)
            return true


        return userRepository.saveName(param=param)
    }

}