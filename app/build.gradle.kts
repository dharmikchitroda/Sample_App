
    plugins {
        alias(libs.plugins.android.application)
        alias(libs.plugins.kotlin.android)
        id("com.google.devtools.ksp")
        id("com.google.dagger.hilt.android")

        //
    }

    android {
        namespace = "com.example.sample_app"
        compileSdk = 36

        defaultConfig {
            applicationId = "com.example.sample_app"
            minSdk = 28
            targetSdk = 36
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
            viewBinding = true
            dataBinding = true
        }

    }

    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        // viewmodel
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")

        // constraint layout
        implementation("androidx.constraintlayout:constraintlayout:2.2.1")

        // Room
        val room_version = "2.6.1"
        implementation("androidx.room:room-runtime:$room_version")
        ksp("androidx.room:room-compiler:$room_version")
        implementation("androidx.room:room-ktx:$room_version")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.11.0")
        implementation("com.squareup.retrofit2:converter-gson:2.11.0")

        // Hilt
        implementation("com.google.dagger:hilt-android:2.51.1")
        ksp("com.google.dagger:hilt-compiler:2.51.1")

        // intuit
        implementation("com.intuit.sdp:sdp-android:1.1.1")
        implementation("com.intuit.ssp:ssp-android:1.1.1")

        // fragment
        implementation("androidx.fragment:fragment-ktx:1.7.1")

        // image loader glide
        implementation("com.github.bumptech.glide:glide:4.16.0")

        //   Location API
        implementation("com.google.android.gms:play-services-location:21.3.0")
    }