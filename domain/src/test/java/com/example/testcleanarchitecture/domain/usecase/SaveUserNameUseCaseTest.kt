package com.example.testcleanarchitecture.domain.usecase

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName
import com.example.testcleanarchitecturedomain.domain.usecase.SaveUserNameUseCase
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.mock

class SaveUserNameUseCaseTest {
    private val testRepository = mock<UserRepository>()

    @AfterEach
    fun tearDown() {
        Mockito.reset(testRepository) // очистка репозитория после каждого теста
    }

    @Test
    fun `should not save data if name was already saved`() {


        val testUserName = UserName(firstName = "test name", lastName = "test last name")
        Mockito.`when`(testRepository.getName()).thenReturn(testUserName)

        val useCase = SaveUserNameUseCase(userRepository = testRepository)
        val saveUserNameParam = SaveUserNameParam(name = "test name")
        val actual = useCase.execute(saveUserNameParam)
        val expected = true

        Assertions.assertEquals(expected, actual)


        Mockito.verify(testRepository, Mockito.never())
            .saveName(any()) // проверяем что функция save не была вызвана

    }

    @Test
    fun `should return true if save was successful`() {
        val testUserName = UserName(firstName = "test name", lastName = "test last name")

        val expected = true
        val testParam = SaveUserNameParam(name = "new test name")
        Mockito.`when`(testRepository.getName()).thenReturn(testUserName)
        Mockito.`when`(testRepository.saveName(param = testParam)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = testRepository)

        val actual = useCase.execute(testParam)
        Assertions.assertEquals(expected, actual)
        Mockito.verify(testRepository, Mockito.times(1)).saveName(testParam)


    }

    @Test
    fun `should return false if save was successful`() {
        val testUserName = UserName(firstName = "test name", lastName = "test last name")

        val expected = false
        val testParam = SaveUserNameParam(name = "new test name")
        Mockito.`when`(testRepository.getName()).thenReturn(testUserName)
        Mockito.`when`(testRepository.saveName(param = testParam)).thenReturn(expected)

        val useCase = SaveUserNameUseCase(userRepository = testRepository)

        val actual = useCase.execute(testParam)
        Assertions.assertEquals(expected, actual)
        Mockito.verify(testRepository, Mockito.times(1)).saveName(testParam)


    }

}