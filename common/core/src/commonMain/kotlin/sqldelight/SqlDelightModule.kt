package sqldelight

import com.larkes.goshellapp.common.core.GoShellDatabase
import org.koin.dsl.module
import platform.PlatformConfiguration

internal val sqlDelightModule = module {

    single {
        GoShellDatabase(SqlDelightDriverFactory(get()).makeDriver())
    }

}