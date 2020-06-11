package com.isa.jokevault

import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.Joke
import com.isa.jokevault.model.JokeRepository
import com.isa.jokevault.presenter.InfoContract
import com.isa.jokevault.presenter.JokePresenter
import com.isa.jokevault.presenter.MainContract
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class JokePresenterCheck {

    @Mock
    var mainContract: MainContract.View = Mockito.mock(MainContract.View::class.java)
    @Mock
    var jokeRepository: JokeRepository = Mockito.mock(JokeRepository::class.java)
    @Mock
    var joke: Joke = Mockito.mock(Joke::class.java)
    @Mock
    var mockedCall: Call<Joke> = Mockito.mock(Call::class.java) as Call<Joke>
    @Mock
    var depInjector: DependencyInjectorImpl = Mockito.mock(DependencyInjectorImpl::class.java)

    lateinit var jokePresenter: JokePresenter

    @Test
    fun mvpArchitecture_isWorking(){

        //Checks if the loadJoke method is called in the joke repository when
        //the get get joke button is tapped and then if the display joke method is called in the view

        `when`(depInjector.jokeRepository()).thenReturn(jokeRepository)
        jokePresenter = JokePresenter(mainContract, depInjector)

        `when`(jokeRepository.loadJoke(jokePresenter)).thenAnswer{
            (it.arguments[0] as Callback<Joke>).onResponse(mockedCall, Response.success(joke))
        }

        jokePresenter.onLoadJokeTapped()

        verify(jokeRepository).loadJoke(jokePresenter)
        verify(mainContract).displayJoke(joke)

    }

}