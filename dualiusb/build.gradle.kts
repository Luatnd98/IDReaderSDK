plugins {
    alias(libs.plugins.android.application)
    id("maven-publish")
}

group = "com.github.Luatnd98"
version = "1.0.0"

configure<PublishingExtension> {
    publications {
        create<MavenPublication>("maven") {
            artifact(file("dualiusb-v1.0.14.aar")) {
                extension = "aar"
            }
        }
    }
}

android {
    namespace = "com.duali.dualiusb"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.duali.dualiusb"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}