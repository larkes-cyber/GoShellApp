plugins{

    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")


}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                implementation(project(":common:auth:api"))
                implementation(project(":common:core"))
            }
        }

    }

}


android{
    namespace = "com.larkes.myshell.common.profile.api"
}

