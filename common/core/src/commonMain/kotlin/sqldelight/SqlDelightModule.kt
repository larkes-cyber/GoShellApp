package sqldelight

import com.larkes.goshellapp.RoomDatabase
import org.koin.dsl.module
import platform.PlatformConfiguration

internal val sqlDelightModule = module {

    single { RoomDatabase(SqlDelightDriverFactory(get()).makeDriver(RoomDatabase.Schema, "rooms")) }

}