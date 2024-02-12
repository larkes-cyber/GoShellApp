plugins{

    id("multiplatform")

}

kotlin{

    sourceSets{

        commonMain{
            dependencies{

                implementation(project(":common:auth:api"))
                implementation(Dependencies.Other.ViewModel.core)

            }
        }

    }

}

android{
    namespace = "com.larkes.goshell.auth.presentation"
}
