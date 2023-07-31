plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
}

android {
  namespace = "com.serj113.feature.pokemonlist"
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
    viewBinding = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.1"
  }
}

dependencies {
  implementation(project(":core_model"))
  implementation(project(":core_domain"))

  implementation(libs.kotlin.bom)
  implementation(libs.androidx.core)
  implementation(libs.androidx.lifecycle)
//  implementation(libs.androidx.runtime)
//  implementation(libs.androidx.lifecycle.extensions)
//  implementation(libs.androidx.viewmodel)
  implementation(libs.androidx.activity)
  implementation(libs.fragmentktx)

  // compose
  implementation(platform(libs.compose.bom))
  implementation(libs.compose.ui)
  implementation(libs.compose.ui.graphics)
  implementation(libs.compose.ui.tooling)
  implementation(libs.compose.material)

  // debug
  debugImplementation(libs.debug.compose.ui.tooling)

  // hilt
  implementation(libs.hilt)
  kapt(libs.hilt.kapt)
  implementation(libs.hilt.androidx)
  kapt(libs.hilt.androidx.kapt)

  // test
  testImplementation(libs.junit)
  androidTestImplementation(libs.junit.ext)
  androidTestImplementation(libs.espresso.core)
  androidTestImplementation(libs.atest.compose.bom)
  androidTestImplementation(libs.atest.compose.junit)
}