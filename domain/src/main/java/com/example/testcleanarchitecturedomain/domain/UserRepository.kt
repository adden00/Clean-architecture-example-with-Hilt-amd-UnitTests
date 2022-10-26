package com.example.testcleanarchitecture.domain

import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName

interface UserRepository {
    fun getName(): UserName
    fun saveName(param: SaveUserNameParam): Boolean
}