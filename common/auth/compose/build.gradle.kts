plugins{

    id("multiplatform")

}

kotlin{

    sourceSets{
        
        commonMain{
            dependencies{
                implementation(project(":common:compose-utils"))
                implementation(project(":common:core-utils"))
                implementation(project(":common:auth:presentation"))
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
    namespace = "com.larkes.goshell.common.auth.compose"
}
