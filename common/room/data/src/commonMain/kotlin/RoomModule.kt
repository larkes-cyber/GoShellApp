import ktor.RoomKtorDataSource
import ktor.RoomKtorDataSourceImpl
import org.koin.dsl.module
import sqldelight.RoomSqlDelightDataSource
import sqldelight.RoomSqlDelightDataSourceImpl

val roomModule = module {

    single<RoomKtorDataSource> { RoomKtorDataSourceImpl(get()) }
    single<RoomSqlDelightDataSource> { RoomSqlDelightDataSourceImpl(get()) }
    single<RoomRepository> { RoomRepositoryImpl(get(), get(), get()) }

}