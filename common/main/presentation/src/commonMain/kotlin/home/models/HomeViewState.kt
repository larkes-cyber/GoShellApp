package home.models

import models.HomeDevices

data class HomeViewState(

    val homeDevices: List<HomeDevices> = emptyList()

)