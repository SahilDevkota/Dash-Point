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

    private lateinit var viewModel: DashboardViewModel
    private lateinit var repository : DashboardRepository
    private val testDispatcher = StandardTestDispatcher()


    @Before
    fun setup(){
        repository = mockk()
        Dispatchers.setMain(testDispatcher)
        viewModel = DashboardViewModel(repository)

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
        val response = viewModel.getTheData("test-key")
        assertEquals(2,response.body()?.entities?.size)
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }



}