plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
}

android {
  namespace = "com.serj113.pokedex.core.test"
  compileSdk = Configuration.compileSdk

  defaultConfig {
    minSdk = Configuration.minSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {
  testRuntimeOnly(libs.junit5.jupiter.engine)

  api(libs.junit)
  api(libs.mockk)
  api(libs.elmyr)
  api(libs.kotest)
  api(libs.coroutine.test)
  api(libs.junit5.jupiter.api)
  api(libs.junit5.jupiter.params)
}