package com.example.S8133149Assignment2

import com.example.S8133149Assignment2.Repository.UserRepository
import com.example.S8133149Assignment2.ViewModel.LoginViewModel
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

    //Creating an instance
    private lateinit var viewModel: LoginViewModel
    private lateinit var repository: UserRepository

    //Now over here, we're using StandardTestDispatcher. This helps us to control the coroutines during testing
    private val testDispatcher = StandardTestDispatcher();

    @Before
    fun setUp(){

        //Creates a fake repository
        repository = mockk()

        //Replacing the default dispatcher with a testdispatcher
        Dispatchers.setMain(testDispatcher)

        //Creates the view model using the fake repository
        viewModel = LoginViewModel(repository)

        //Defining the fake responses
        coEvery {
            repository.login(any())
        }returns Response.success(
            LoginResponse(keypass = "test-key")
        )
    }


    @Test
    fun `sendRequest returns successful response` () = runTest {

        //Calls the viewmodel using the test username and password
        val response = viewModel.sendRequest("testUser","password")

        //Checks that the response returned matches 'test-key'
        assertEquals("test-key",response.body()?.keypass)
    }


    @Test
    fun `sendRequest returns 401 for wrong credentials` () = runTest {

        //Creating a fake response that will return 401
        coEvery {
            repository.login(any())
        }returns Response.error(401,"".toResponseBody(null))

        //Calls the viewmodel using the test keypass
        val response = viewModel.sendRequest("wrongusername","wrongpassword")

        //Checks that the response returns 401
        assertEquals(401,response.code())
    }

    // Resetting the dispatcher
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }



}