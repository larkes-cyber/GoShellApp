import ktor.ktorModule
import org.koin.dsl.module
import serialization.serializationModule
import setting.settingsModule

val coreModule = ktorModule  + serializationModule + settingsModule
