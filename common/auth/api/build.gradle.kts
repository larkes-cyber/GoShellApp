plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:core-utils"))
            }
        }

    }

}

android{
    namespace = "com.larkes.myshell.common.auth.api"
}
