package sqldelight

import com.larkes.goshellapp.common.core.GoShellDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import platform.PlatformConfiguration

actual class SqlDelightDriverFactory actual constructor(private val platformConfiguration: PlatformConfiguration){
    actual fun makeDriver(): SqlDriver {
        return NativeSqliteDriver(GoShellDatabase.Schema, "goshell.db")
    }
}