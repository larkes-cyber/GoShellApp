plugins{
    id("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:profile:api"))
            }
        }

    }

}

android{
    namespace = "com.larkes.myshell.common.profile.data"
}