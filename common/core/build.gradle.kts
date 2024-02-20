plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}

sqldelight {
    database("GoShellDatabase") {
        packageName = "com.larkes.goshellapp.common.core"
    }
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
                api(Dependencies.SqlDelight.core)
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
                implementation(Dependencies.SqlDelight.iosDriver)
            }
        }

    }


}

android{
    namespace = "com.larkes.myshell.common.core"
}
