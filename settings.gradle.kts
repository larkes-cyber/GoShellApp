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
include(":common:profile:api")
include(":common:profile:data")
include(":common:profile:presentation")
include(":common:device:api")
include(":common:device:data")
include(":common:device:presentation")
include(":common:room:api")
include(":common:room:data")
include(":common:room:presentation")
include(":common:room:compose")
include(":common:room:presentation")
include(":common:compose-utils")
include(":common:core-utils")
include(":common:root-compose")
include(":common:root-core")
include(":common:root-ios")
include(":common:main:compose")
include(":common:main:presentation")
