package sqldelight

import com.larkes.goshellapp.GoShellDatabase
import org.koin.dsl.module
import platform.PlatformConfiguration

internal val sqlDelightModule = module {

    single {
        GoShellDatabase(SqlDelightDriverFactory(get()).makeDriver(GoShellDatabase.Schema))
    }

}