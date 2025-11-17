object Configuration {
  const val compileSdk = 35
  const val targetSdk = 35
  const val minSdk = 23
  const val majorVersion = 1
  const val minorVersion = 0
  const val patchVersion = 0
  val versionName = "$majorVersion.$minorVersion.$patchVersion"
  val versionCode = (majorVersion*10000)+(minorVersion*100)+patchVersion
}