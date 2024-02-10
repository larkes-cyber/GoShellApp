
plugins{
    id("multiplatform")
}


kotlin{
    sourceSets{
        commonMain{
            dependencies{
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
            }
        }
    }
}


android{
    namespace = "com.larkes.goshell.root.core"
}