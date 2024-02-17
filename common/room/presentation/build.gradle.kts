plugins{
    id("multiplatform")
}

kotlin{

    sourceSets{

        commonMain{
            dependencies{
                api(project(":common:device:api"))
                implementation(project(":common:room:api"))
                implementation(Dependencies.Other.ViewModel.core)
            }
        }

    }

}

android{
    namespace = "com.larkes.goshell.common.room.presentation"
}