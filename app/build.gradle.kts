    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.android)
        alias(libs.plugins.kotlin.compose)
        id("com.google.devtools.ksp")
    }

    android {
        namespace = "com.example.farmer"
        compileSdk = 35

        defaultConfig {
            applicationId = "com.example.farmer"
            minSdk = 26
            targetSdk = 35
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
        kotlinOptions {
            jvmTarget = "11"
        }
        buildFeatures {
            compose = true
        }
    }

    dependencies {

        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.material3)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)

        //navigation
        implementation("androidx.navigation:navigation-compose:2.8.9")

        //room
        implementation("androidx.room:room-runtime:2.7.0")
        implementation("androidx.room:room-ktx:2.7.0")
        ksp("androidx.room:room-compiler:2.7.0")

       //viewModel
        implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

        // Dagger Hilt
        implementation("com.google.dagger:hilt-android:2.51.1")
        ksp("com.google.dagger:hilt-android-compiler:2.51.1")
        implementation("androidx.hilt:hilt-navigation-compose:1.2.0")



    }