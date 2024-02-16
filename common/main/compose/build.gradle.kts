plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                api(project(":common:main:presentation"))
                implementation(project(":common:compose-utils"))
                implementation(project(":common:core-utils"))
                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.odyssey)

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }

        androidMain{
            dependencies{

                implementation(Dependencies.Android.Image.core)
                implementation(Dependencies.Android.Image.compose)

            }
        }

    }

}

android{
    namespace = "com.larkes.goshell.common.main.compose"
}