package com.example.testcleanarchitecture.domain.usecase

import com.example.testcleanarchitecture.domain.UserRepository
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

//class TestRepository: UserRepository{
//    override fun getName(): UserName {
//        return UserName(firstName = "testFirstName", lastName = "testLastName")
//    }
//
//    override fun saveName(param: SaveUserNameParam): Boolean {
//        TODO("Not yet implemented")
//    }
//
//}

class GetUserNameUseCaseTest {

    private val testRepository = mock<UserRepository>() // mockito создает фальшивый репозиторий
    @Test
    fun `should return the same data as in repository`() {
        val testUserName = UserName(firstName = "testFirstName", lastName = "testLastName")
        Mockito.`when`(testRepository.getName()).thenReturn(testUserName)



        val useCase = GetUserNameUseCase(userRepository = testRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "testFirstName", lastName = "testLastName")
        Assertions.assertEquals(actual, expected)




    }

}