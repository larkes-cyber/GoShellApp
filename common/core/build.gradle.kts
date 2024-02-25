plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("app.cash.sqldelight")
}


sqldelight {
    databases {
        create("GoShellDatabase") {
            packageName.set("com.larkes.goshellapp")
            schemaOutputDirectory.set(File("src/commonMain/sqldelight/database/schema"))
            migrationOutputDirectory.set(File("src/commonMain/sqldelight/database/migrations"))
            generateAsync.set(true)
        }
    }
    linkSqlite = true
}




kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(Dependencies.Coroutines.core)
                api(Dependencies.Ktor.core)
                implementation(Dependencies.Ktor.serialization)
                implementation(Dependencies.Ktor.cio)
                implementation(Dependencies.Ktor.negotiation)
                api(Dependencies.Settings.settings)
                api(Dependencies.Koin.core)
                api(Dependencies.Serialization.serialization)
            }
        }
        androidMain {
            dependencies {
                implementation(Dependencies.Ktor.android_client)
                implementation(Dependencies.SqlDelight.androidDriver)
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios_darwing)
                implementation(Dependencies.Ktor.ios_client)
                api(Dependencies.SqlDelight.iosDriver)
            }
        }

    }


}


android{
    namespace = "com.larkes.myshell.common.core"
}
