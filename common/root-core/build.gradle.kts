
plugins{
    id("multiplatform")
}


kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:device:data"))
                implementation(project(":common:room:data"))
                implementation(project(":common:profile:data"))
            }
        }
    }
}


android{
    namespace = "com.larkes.goshell.root.core"
}