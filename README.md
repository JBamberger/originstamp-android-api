# originstamp_android_client
Android Client for the OriginStamp API

The current version tag is: 0.16

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
            compile 'com.github.thhepp:originstamp_android_client:0.16'
        }
        
# How To Use It

Note: OriginStamp only accepts SHA-256 in Hex representation. 

## Get Hash Information

The request looks up the hash information for a certain SHA256 hash. If the hash does not exist, OriginStamp will automatically create a new entry.

        // init OriginStamp API Client
        OriginStampAPI originStampAPI = new OriginStampAPI(
                // hand over the api key
                this.context.getString(R.string.originStampApi)
        );

        // request and get information
        return originStampAPI.getHashInformation(pHashInHex);
        
## Store Hash Information

The request looks up the hash information for a certain SHA256 hash. If the hash does not exist, OriginStamp will automatically create a new entry.

        // init OriginStamp API Client
        OriginStampAPI originStampAPI = new OriginStampAPI(
                // hand over the api key
                this.context.getString(R.string.originStampApi)
        );

        return originStampAPI.storeHashInformation(pHashInHex, pHashRequest);
       
       
## Get Seed Information

The seed file is needed for the validation.

        // init OriginStamp API Client
        OriginStampAPI originStampAPI = new OriginStampAPI(
                // hand over the api key
                this.context.getString(R.string.originStampApi)
        );

        return originStampAPI.getSeed(pHashInHex);
