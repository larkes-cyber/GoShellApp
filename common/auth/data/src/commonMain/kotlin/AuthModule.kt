import ktor.AuthKtorDataSource
import ktor.AuthKtorDataSourceImpl
import org.koin.dsl.module
import settings.AuthSettingDataSource
import settings.AuthSettingDataSourceImpl

val authModule = module {

    single<AuthKtorDataSource> { AuthKtorDataSourceImpl(get()) }
    single<AuthSettingDataSource> { AuthSettingDataSourceImpl(get()) }
    single<AuthRepository> { AuthRepositoryImpl(get(), get()) }

}