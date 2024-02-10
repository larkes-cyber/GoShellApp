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
                implementation(project(":common:core-utils"))

            }

        }

    }

}


android{
    namespace = "com.larkes.myshell.common.auth.data"
}
