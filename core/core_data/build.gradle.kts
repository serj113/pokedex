plugins {
  id(libs.plugins.android.library.get().pluginId)
  id(libs.plugins.kotlin.android.get().pluginId)
  id(libs.plugins.kotlin.kapt.get().pluginId)
  id(libs.plugins.hilt.get().pluginId)
}

android {
  namespace = "com.serj113.pokedex.core.data"
  compileSdk = Configuration.compileSdk

  defaultConfig {
    minSdk = Configuration.minSdk

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
  tasks.withType<Test> {
    useJUnitPlatform()
  }
}

dependencies {
  implementation(project(":core_domain"))
  implementation(project(":core_model"))
  implementation(libs.androidx.core)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)

  // retrofit
  implementation(libs.retrofit)
  implementation(libs.retrofit.moshi)
  implementation(libs.okhttp)

  // hilt
  implementation(libs.hilt)
  kapt(libs.hilt.kapt)

  // arrow
  implementation(libs.arrow.core)
  implementation(libs.arrow.fx.coroutines)

  // test
  testImplementation(project(":core_test"))
  testImplementation(libs.junit)
  testImplementation(libs.kotest)
  androidTestImplementation(libs.junit.ext)
  androidTestImplementation(libs.espresso.core)
}