plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{

                implementation(project(":common:device:api"))
                implementation(Dependencies.Other.ViewModel.core)

            }
        }

    }

}

android{
    namespace = "com.larkes.goshell.common.main.presentation"
}