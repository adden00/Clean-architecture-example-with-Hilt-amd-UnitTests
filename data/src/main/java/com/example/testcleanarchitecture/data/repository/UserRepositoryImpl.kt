package com.example.testcleanarchitecture.data.repository

import com.example.testcleanarchitecture.data.storage.models.User
import com.example.testcleanarchitecture.data.storage.UserStorage
import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName
import javax.inject.Inject


class UserRepositoryImpl (private val userStorage: UserStorage): UserRepository {


    override fun saveName(param: SaveUserNameParam): Boolean {
        return userStorage.save(param.toStorage())
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return user.toDomain()
    }

    private fun User.toDomain(): UserName {
        return UserName(firstName = this.firstName, lastName = this.lastName)
    }

    private fun SaveUserNameParam.toStorage(): User {
        return User(firstName = this.name, lastName = "")
    }
}