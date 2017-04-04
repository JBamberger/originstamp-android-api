# originstamp_android_client
Android Client for the OriginStamp API


Use this project to communicate with the OriginStamp API.

add the following line to your project: build.gradle
        allprojects {
            repositories {
                .
                .
                .
                maven { url "https://jitpack.io" }
            }
        }
        
        
And this one to your project module: build.gradle

        dependencies {
            .
            .
            .
            compile 'com.github.thhepp:originstamp_android_client:0.12'
        }
