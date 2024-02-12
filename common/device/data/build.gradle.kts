plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{

                implementation(project(":common:device:api"))

            }
        }

    }

}

android{
    namespace = "com.larkes.myshell.common.device.data"
}
