plugins{
    id("multiplatform")
    kotlin("plugin.serialization")
}

kotlin{

    sourceSets{

       commonMain{
           dependencies{
               implementation(project(":common:room:api"))
           }
       }

    }

}


android{
    namespace = "com.larkes.myshell.common.room.data"
}
