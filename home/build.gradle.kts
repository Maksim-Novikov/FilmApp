plugins {
    id("com.android.library")
    id("common-module-plugin")
}
dependencies {
    implementation(project(path = ":common"))
}