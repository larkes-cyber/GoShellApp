enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "GoShellApp"
include(":androidApp")
include(":common:core")
include(":common:auth:api")
include(":common:auth:data")
include(":common:auth:presentation")
include(":common:auth:compose")
include(":common:profile")
include(":common:device")
include(":common:room")
include(":common:compose-utils")
include(":common:core-utils")
include(":common:root-compose")
include(":common:root-core")
include(":common:root-ios")