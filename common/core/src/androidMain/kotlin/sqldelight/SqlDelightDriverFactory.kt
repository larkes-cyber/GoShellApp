package sqldelight

import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.QueryResult
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.larkes.goshellapp.GoShellDatabase

import platform.PlatformConfiguration

actual class SqlDelightDriverFactory actual constructor(private val platformConfiguration:PlatformConfiguration) {
    actual fun makeDriver(schema: SqlSchema<QueryResult.AsyncValue<Unit>>): SqlDriver {
        return AndroidSqliteDriver(schema.synchronous(),platformConfiguration.androidContext, "goshell.db" )
    }

}