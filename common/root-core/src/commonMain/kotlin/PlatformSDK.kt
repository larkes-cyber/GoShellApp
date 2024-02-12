import di.Inject
import org.koin.core.context.startKoin
import org.koin.dsl.module
import platform.PlatformConfiguration

object PlatformSDK {

    fun init(configuration: PlatformConfiguration) {
        val diTree = startKoin {
            modules(module {
                single { configuration }
            })
            modules(coreModule)
            modules(authModule)
            modules(deviceModule)
        }.koin
        Inject.createDependencies(diTree)
    }

}