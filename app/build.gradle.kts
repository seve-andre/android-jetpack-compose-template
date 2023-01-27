plugins {
    id(Plugins.androidApp)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.ksp) version Versions.ksp
    id(Plugins.hilt)
    id(Plugins.detekt).version(Versions.detekt)
    id(Plugins.kotlinSerialization)
}
android {
    namespace = AppConfig.applicationId

    compileSdk = AppConfig.compileSdkVersion
    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdkVersion
        targetSdk = AppConfig.targetSdkVersion
        versionCode = ReleaseConfig.appVersionCode
        versionName = ReleaseConfig.appVersionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
    packagingOptions {
        resources.excludes.add("/META-INF/AL2.0")
        resources.excludes.add("/META-INF/LGPL2.1")
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
}

kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}

kapt {
    correctErrorTypes = true
}

detekt {
    buildUponDefaultConfig = true
    allRules = false
    config = files("$projectDir/config/detekt/detekt.yml")

    // REMOVE once edited RepositoryModule and AppDatabase
    ignoreFailures = true

    autoCorrect = true
}

tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        md.required.set(true) // simple Markdown format
    }
}

tasks.getByPath("preBuild").dependsOn("detekt")

dependencies {
    // Kotlin
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.Coroutines.android)
    implementation(Dependencies.Kotlin.serialization)

    // UI (Compose + Accompanist + Icons + ...)
    implementation(Dependencies.Compose.activity)
    implementation(Dependencies.Compose.runtime)
    implementation(Dependencies.Compose.foundation)
    implementation(Dependencies.Compose.layout)
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Compose.animation)
    implementation(Dependencies.Compose.material3)
    implementation(Dependencies.Compose.material3WindowSize)
    implementation(Dependencies.Accompanist.systemUiController)
    implementation(Dependencies.Accompanist.placeholder)
    implementation(Dependencies.AndroidX.Lifecycle.viewModelCompose)
    implementation(Dependencies.evaIcons)

    // Navigation
    implementation(Dependencies.Navigation.compose)
    ksp(Dependencies.Navigation.ksp)

    // Dependency Injection
    implementation(Dependencies.Hilt.android)
    kapt(Dependencies.Hilt.compiler)

    // Room
    implementation(Dependencies.Room.runtime)
    kapt(Dependencies.Room.compiler)
    implementation(Dependencies.Room.ktx)

    // Datastore (previously SharedPreferences)
    implementation(Dependencies.Datastore.proto)

    // Logging
    implementation(Dependencies.timber)

    // Tests
    testImplementation(Dependencies.Tests.junit)
    androidTestImplementation(Dependencies.Tests.androidJUnit)
    androidTestImplementation(Dependencies.Tests.espressoCore)
    androidTestImplementation(Dependencies.Tests.composeJUnit)

    // Desugaring - https://developer.android.com/studio/write/java8-support-table
    coreLibraryDesugaring(Dependencies.jdkDesugar)

    // Formatting
    detektPlugins(Dependencies.detektFormatting)
}
