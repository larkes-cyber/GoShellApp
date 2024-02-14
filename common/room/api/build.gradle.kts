plugins{
    id("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                api(project(":common:core"))
                api(project(":common:auth:api"))
            }
        }

    }

}

android{
    namespace = "com.larkes.myshell.common.room.api"
}
