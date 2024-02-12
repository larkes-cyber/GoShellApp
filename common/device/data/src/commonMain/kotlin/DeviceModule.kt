import ktor.DeviceKtorDataSource
import ktor.DeviceKtorDataSourceImpl
import org.koin.dsl.module

val deviceModule = module {

    single<DeviceKtorDataSource> {
        DeviceKtorDataSourceImpl(get())
    }

    single<DeviceRepository> {
        DeviceRepositoryImpl(get(), get())
    }

}