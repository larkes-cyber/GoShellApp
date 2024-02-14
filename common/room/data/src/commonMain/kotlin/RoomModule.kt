import ktor.RoomKtorDataSource
import ktor.RoomKtorDataSourceImpl
import org.koin.dsl.module

val roomModule = module {

    single<RoomKtorDataSource> { RoomKtorDataSourceImpl(get()) }
    single<RoomRepository> { RoomRepositoryImpl(get(), get()) }

}