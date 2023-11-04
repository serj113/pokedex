plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
}

android {
  namespace = "com.serj113.pokedex.common.presentation"
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
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.1"
  }
}

dependencies {
  implementation(project(":core_model"))

  implementation(libs.kotlin.stdlib)

  implementation(libs.androidx.lifecycle)
  implementation(libs.androidx.viewmodel)

  implementation(platform(libs.compose.bom))
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.graphics)
  implementation(libs.compose.ui.tooling)
  implementation(libs.compose.material)
  implementation(libs.compose.ui.graphics.android)
}