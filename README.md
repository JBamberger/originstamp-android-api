
**THIS LIBRARY IS DISCONTINUED SINCE THE UPSTREAM REPOSITORY VANISHED**
If you are interested in an up to date alternative, check out [this library](https://github.com/OriginStampTimestamping/originstamp-client-java).


# OriginStamp for Android
Android Client for the OriginStamp API

The current version tag is: 0.18

Use this project to communicate with the OriginStamp API. You can use this library to store or to retrieve hash information which is timestamped by OriginStamp (https://originstamp.org).

# ProGuard

        -keep class org.originstamp.originstampandroidclient.** { *; }
        -dontwarn org.originstamp.originstampandroidclient.**

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
            compile 'com.github.thhepp:OriginStamp4J-android:0.18'
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
