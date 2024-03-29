plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                api(project(":common:core"))
            }
        }

    }

}

android{
    namespace = "com.larkes.myshell.common.auth.api"
}
