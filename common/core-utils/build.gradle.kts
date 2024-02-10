plugins{
    id("multiplatform")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{
        
        commonMain{

           dependencies{
               implementation(Dependencies.Serialization.serialization)
           }

        }

    }

}

android{
    namespace = "com.larkes.myshell.common.core.utils"
}
