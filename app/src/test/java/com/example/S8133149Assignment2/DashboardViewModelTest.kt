package com.example.S8133149Assignment2

import com.example.S8133149Assignment2.Repository.DashboardRepository
import com.example.S8133149Assignment2.ViewModel.DashboardViewModel
import com.example.S8133149Assignment2.response.DashboardResponse
import com.example.S8133149Assignment2.response.entityList
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    //Creating an instance
    private lateinit var viewModel: DashboardViewModel
    private lateinit var repository : DashboardRepository

    //Now over here, we're using StandardTestDispatcher. This helps us to control the coroutines during testing
    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setup(){

        //Creates a fake repository
        repository = mockk()

        //Replacing the default dispatcher with a testdispatcher
        Dispatchers.setMain(testDispatcher)

        //Creates the view model using the fake repository
        viewModel = DashboardViewModel(repository)


        //Defining the fake responses
        coEvery {
            repository.getDashboardDetail(any())
        } returns Response.success(DashboardResponse(entities = listOf(
            entityList(
                courseCode = "NIT2000",
                courseName = "IT ethics",
                instructor = "Mr. Professor",
                credits = 28,
                description = "This unit teaches you about the rules and regulation followed in IT sectors."
            ),
            entityList(
                courseCode = "NIT2023",
                courseName = "Web Development",
                instructor = "Bruce Warner",
                credits = 28,
                description = "This unit teaches you about web development tools"
            )), entityTotal = 2))
    }


    @Test
    fun `getTheData returns successful response` () = runTest(){

        //Calls the viewmodel using the test keypass
        val response = viewModel.getTheData("test-key")

        //Checks that the two entities were returned
        assertEquals(2,response.body()?.entities?.size)
    }


    // Resetting the dispatcher
    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }



}