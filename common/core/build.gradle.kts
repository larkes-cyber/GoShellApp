plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
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
            }
        }
        iosMain {
            dependencies {
                implementation(Dependencies.Ktor.ios_darwing)
                implementation(Dependencies.Ktor.ios_client)
            }
        }

    }
}

android{
    namespace = "com.larkes.myshell.common.core"
}
