package home

import DeviceRepository
import io.github.alexgladkov.kviewmodel.BaseSharedViewModel
import di.Inject
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState
import kotlinx.coroutines.launch

class HomeViewModel:BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState = HomeViewState()
) {

    private val deviceRepository:DeviceRepository = Inject.di.get()
    init {
        fetchHomeDevices()
    }
    override fun obtainEvent(viewEvent: HomeEvent) {
        when(viewEvent){

            is HomeEvent.SwitchDevicesActive -> {
                switchDevicesActive(id = viewEvent.id)
            }

        }
    }

    private fun switchDevicesActive(id:String) {
        viewModelScope.launch {
            deviceRepository.switchDevicesActive(id)
        }
    }

    private fun fetchHomeDevices(){
        viewModelScope.launch {
            try {
                viewState = viewState.copy(
                    homeDevices = deviceRepository.fetchHomeDevices()
                )
            }catch (e:Exception){
                println(e.toString())
            }
        }

    }
}