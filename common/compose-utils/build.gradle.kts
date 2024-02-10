plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{

            dependencies{
                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.odyssey)

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }

        }

    }

}

android{
    namespace = "com.larkes.goshell.common.compose.utils"
}
