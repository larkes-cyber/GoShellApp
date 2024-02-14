
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
            }
        }
    }
}


android{
    namespace = "com.larkes.goshell.root.core"
}