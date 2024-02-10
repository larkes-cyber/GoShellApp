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

        }

        sourceSets{

            commonMain{
                dependencies{
                    implementation(project(":common:core"))
                }
            }

            iosMain{
                dependencies{
                    api(project(":common:core"))
                }
            }

        }

    }

}

android{
    namespace = "com.larkes.goshell.mobile.root.ios"
}



