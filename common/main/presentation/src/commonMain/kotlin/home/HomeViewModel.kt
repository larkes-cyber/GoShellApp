package home

import DeviceRepository
import com.adeo.kviewmodel.BaseSharedViewModel
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
        viewModelScope.launch {
            viewState = viewState.copy(
                homeDevices = deviceRepository.fetchHomeDevices()
            )
        }
    }
    override fun obtainEvent(viewEvent: HomeEvent) {
        when(viewEvent){

            is HomeEvent.SwitchDevicesActive -> {
                switchDevicesActive(id = viewEvent.id)
            }

        }
    }

    private fun switchDevicesActive(id:String) {
        viewState.homeDevices.forEach {
            if(it.typeId == id){

            }
        }
    }
}