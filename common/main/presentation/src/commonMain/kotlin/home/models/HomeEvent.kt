package home.models

sealed class HomeEvent {
    data class SwitchDevicesActive(val id:String):HomeEvent()

}