plugins {
//    alias(libs.plugins.android.application)
    id("com.android.library")
    id("maven-publish")
}

group = "com.github.Luatnd98"
version = "dualiusb"

//configure<PublishingExtension> {
//    publications {
//        create<MavenPublication>("maven") {
//            artifact(file("dualiusb-v1.0.14.aar")) {
//                extension = "aar"
//            }
//        }
//    }
//}

android {
    namespace = "com.duali.dualiusb"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        targetSdk = 34
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.Luatnd98"
            artifactId = "dualiusb"
            version = "1.0.14"

            artifact(file("dualiusb-v1.0.14.aar")) {
                extension = "aar"
            }
        }
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}