import ktor.ProfileKtorDataSource
import ktor.ProfileKtorDataSourceImpl
import org.koin.dsl.module

val profileModule = module {

    single<ProfileKtorDataSource> { ProfileKtorDataSourceImpl(get()) }
    single<ProfileRepository> { ProfileRepositoryImpl(get(), get()) }

}