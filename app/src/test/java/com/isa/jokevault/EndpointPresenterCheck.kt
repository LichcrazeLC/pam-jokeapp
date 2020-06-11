package com.isa.jokevault

import com.isa.jokevault.model.Endpoint
import com.isa.jokevault.model.EndpointRepository
import com.isa.jokevault.model.Joke
import com.isa.jokevault.model.JokeRepository
import com.isa.jokevault.presenter.EndpointPresenter
import com.isa.jokevault.presenter.InfoContract
import com.isa.jokevault.presenter.JokePresenter
import com.isa.jokevault.presenter.MainContract
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
class EndpointPresenterCheck {

    @Mock
    var infoContract: InfoContract.View = Mockito.mock(InfoContract.View::class.java)
    @Mock
    var endpointRepository: EndpointRepository = Mockito.mock(EndpointRepository::class.java)
    @Mock
    var endpoint: Endpoint = Mockito.mock(Endpoint::class.java)
    @Mock
    var mockedCall: Call<List<Endpoint>> = Mockito.mock(Call::class.java) as Call<List<Endpoint>>
    @Mock
    var depInjector: DependencyInjectorImpl = Mockito.mock(DependencyInjectorImpl::class.java)

    lateinit var endpointPresenter: EndpointPresenter

    @Test
    fun mvpArchitecture_isWorking(){

        //Checks if the loadEndpoints method is called in the endpoint repository when
        //the info activity is spawned and then if the display endpoints method is called in the view

        `when`(depInjector.endpointRepository()).thenReturn(endpointRepository)
        endpointPresenter = EndpointPresenter(infoContract, depInjector)

        `when`(endpointRepository.loadEndpoints(endpointPresenter)).thenAnswer{
            (it.arguments[0] as Callback<List<Endpoint>>).onResponse(mockedCall, Response.success(
                emptyList()))
        }

        endpointPresenter.onViewCreated()

        verify(endpointRepository).loadEndpoints(endpointPresenter)
        verify(infoContract).displayEndpoints(emptyList())

    }

}