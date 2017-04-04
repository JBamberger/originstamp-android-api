# originstamp_android_client
Android Client for the OriginStamp API

The current version tag is: 0.12

Use this project to communicate with the OriginStamp API. You can use this library to store or to retrieve hash information which is timestamped by OriginStamp (https://originstamp.org).


# Add Gradle dependency

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
        
# How To Use It

Note: OriginStamp only accepts SHA-256 in Hex representation. 

## get hash information

        // init OriginStamp API Client
        OriginStampAPI originStampAPI = new OriginStampAPI(
                // hand over the api key
                this.context.getString(R.string.originStampApi)
        );

        // request and get information
        return originStampAPI.getHashInformation(pHashInHex);
        
## Store Hash Information

        // init OriginStamp API Client
        OriginStampAPI originStampAPI = new OriginStampAPI(
                // hand over the api key
                this.context.getString(R.string.originStampApi)
        );

        return originStampAPI.storeHashInformation(pHashInHex, pHashRequest);
        
# ToDos

Error Handling

If an HTTP error occurs, the library returns "null" as a response.
