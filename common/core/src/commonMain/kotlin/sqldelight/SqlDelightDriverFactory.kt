package sqldelight

import com.squareup.sqldelight.db.SqlDriver
import platform.PlatformConfiguration

expect class SqlDelightDriverFactory constructor(platformConfiguration: PlatformConfiguration){
     fun makeDriver():SqlDriver
}