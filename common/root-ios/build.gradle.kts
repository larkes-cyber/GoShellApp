plugins{
    id("multiplatform")
    kotlin("native.cocoapods")
}

version = "0.0.1"

kotlin{

    cocoapods{
        summary = "GOshell sdk"
        homepage = "https://google.com"
        ios.deploymentTarget = "15.0"

        framework {
            transitiveExport = false
            baseName = "SharedSDK"
            export(project(":common:core"))
            export(project(":common:root-core"))
            export(project(":common:auth:presentation"))
            export(project(":common:main:presentation"))
            export(project(":common:room:presentation"))
        }

        sourceSets{

            commonMain{
                dependencies{
                    implementation(project(":common:core"))
                    implementation(project(":common:root-core"))
                    implementation(project(":common:auth:presentation"))
                    implementation(project(":common:main:presentation"))
                    implementation(project(":common:room:presentation"))
                }
            }

            iosMain{
                dependencies{
                    api(project(":common:core"))
                    api(project(":common:root-core"))
                    api(project(":common:auth:presentation"))
                    api(project(":common:main:presentation"))
                    api(project(":common:room:presentation"))
                }
            }

        }

    }

}

android{
    namespace = "com.larkes.goshell.mobile.root.ios"
}



