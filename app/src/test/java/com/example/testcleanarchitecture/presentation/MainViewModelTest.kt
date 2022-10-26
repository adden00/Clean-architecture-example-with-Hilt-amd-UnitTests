package com.example.testcleanarchitecture.presentation

import androidx.arch.core.executor.ArchTaskExecutor
import androidx.arch.core.executor.TaskExecutor
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import com.example.testcleanarchitecture.data.storage.models.User
import com.example.testcleanarchitecture.domain.models.SaveUserNameParam
import com.example.testcleanarchitecture.domain.models.UserName
import com.example.testcleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.testcleanarchitecturedomain.domain.usecase.SaveUserNameUseCase
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito
import org.mockito.kotlin.mock

class MainViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()


    private val getUseCase = mock<GetUserNameUseCase>()
    private val saveUseCase = mock<SaveUserNameUseCase>()

    @AfterEach
    fun afterEach() {
        Mockito.reset(getUseCase)
        Mockito.reset(saveUseCase)
    }


    @Test
    fun `should save username and return true`() {


        val testSaveText = "testText"
        val params = SaveUserNameParam(name = testSaveText)

        val viewModel =
            MainViewModel(
                getUserNameUseCase = getUseCase,
                saveUserNameUseCase = saveUseCase
            )


        Mockito.`when`(saveUseCase.execute(param = params)).thenReturn(true)
        viewModel.save(testSaveText)

        val expected = "save results = true"
        val actual = viewModel.resultLive.value
        Assertions.assertEquals(expected, actual)
        Mockito.verify(saveUseCase, Mockito.times(1)).execute(param = params)



    }

    @Test
    fun `should save username and return false`() {
        val testSaveText = "testText"
        val params = SaveUserNameParam(name = testSaveText)

        val viewModel =
            MainViewModel(
                getUserNameUseCase = getUseCase,
                saveUserNameUseCase = saveUseCase
            )


        Mockito.`when`(saveUseCase.execute(param = params)).thenReturn(false)
        viewModel.save(testSaveText)

        val expected = "save results = false"
        val actual = viewModel.resultLive.value
        Assertions.assertEquals(expected, actual)
        Mockito.verify(saveUseCase, Mockito.times(1)).execute(param = params)


    }

    @Test
    fun `should load username`() {
        val viewModel = MainViewModel(getUseCase, saveUseCase)

        val userName = UserName("first", "last")
        Mockito.`when`(getUseCase.execute()).thenReturn(userName)
        viewModel.load()
        val actual = viewModel.resultLive.value
        val expected = "first last"
        Assertions.assertEquals(expected, actual)
        Mockito.verify(getUseCase, Mockito.times(1)).execute()




    }

}