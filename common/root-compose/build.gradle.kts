plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.odyssey)
                implementation(Dependencies.Other.ViewModel.compose)

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
                implementation(project(":common:compose-utils"))
            }

        }

        androidMain{

            dependencies{
                implementation(Dependencies.Android.composeActivity)
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:compose"))
                implementation(project(":common:main:compose"))

            }

        }

    }

}


android{
    namespace = "com.larkes.goshell.root.compose"
}
