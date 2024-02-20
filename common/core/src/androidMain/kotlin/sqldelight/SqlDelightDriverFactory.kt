package sqldelight

import android.content.Context
import com.larkes.goshellapp.common.core.GoShellDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import platform.PlatformConfiguration

actual class SqlDelightDriverFactory actual constructor(private val platformConfiguration:PlatformConfiguration) {
    actual fun makeDriver(): SqlDriver {
        return AndroidSqliteDriver(GoShellDatabase.Schema,platformConfiguration.androidContext, "goshell.db" )
    }

}