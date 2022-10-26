package com.example.testcleanarchitecture.data.storage

import com.example.testcleanarchitecture.data.storage.models.User


interface UserStorage {
    fun save(user: User):Boolean
    fun get(): User
}