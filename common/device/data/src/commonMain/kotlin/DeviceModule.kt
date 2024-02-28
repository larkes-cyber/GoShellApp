import ktor.DeviceKtorDataSource
import ktor.DeviceKtorDataSourceImpl
import org.koin.dsl.module
import sqldelight.DeviceSqlDelightDataSource
import sqldelight.DeviceSqlDelightDataSourceImpl

val deviceModule = module {

    single<DeviceSqlDelightDataSource> {
        DeviceSqlDelightDataSourceImpl(get())
    }

    single<DeviceKtorDataSource> {
        DeviceKtorDataSourceImpl(get())
    }

    single<DeviceRepository> {
        DeviceRepositoryImpl(get(), get(), get())
    }

}