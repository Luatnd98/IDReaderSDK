plugins {
    alias(libs.plugins.android.library)
    id("maven-publish")
}

group = "com.github.Luatnd98"
version = "dkcloudid-pcsc"

android {
    namespace = "com.duali.dkcloudid_pcsc"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.github.Luatnd98"
            artifactId = "dkcloudid-pcsc"
            version = "1.0.0"

            artifact(file("dkcloudid-pcsc-v1.0.0.aar")) {
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