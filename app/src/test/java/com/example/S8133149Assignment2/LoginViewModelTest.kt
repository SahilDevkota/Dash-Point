package com.example.S8133149Assignment2

import com.example.S8133149Assignment2.Repository.UserRepository
import com.example.`8133149Assignment2`.ViewModel.LoginViewModel
import com.example.S8133149Assignment2.response.LoginResponse
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel
    private lateinit var repository: UserRepository
    private val testDispatcher = StandardTestDispatcher();

    @Before
    fun setUp(){
        repository = mockk()
        Dispatchers.setMain(testDispatcher)
        viewModel = LoginViewModel(repository)

        coEvery {
            repository.login(any())
        }returns Response.success(
            LoginResponse(keypass = "test-key")
        )
    }


    @Test
    fun `sendRequest returns successful response` () = runTest {

        val response = viewModel.sendRequest("testUser","password")
        assertEquals("test-key",response.body()?.keypass)
    }


    @Test
    fun `sendRequest returns 401 for wrong credentials` () = runTest {

        coEvery {
            repository.login(any())
        }returns Response.error(401,"".toResponseBody(null))

        val response = viewModel.sendRequest("wrongusername","wrongpassword")
        assertEquals(401,response.code())
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }



}