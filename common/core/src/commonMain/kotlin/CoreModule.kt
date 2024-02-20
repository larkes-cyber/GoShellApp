import ktor.ktorModule
import org.koin.dsl.module
import serialization.serializationModule
import setting.settingsModule
import sqldelight.sqlDelightModule

val coreModule = ktorModule  + serializationModule + settingsModule + sqlDelightModule
