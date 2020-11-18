import Versions.APPCOMPAT
import Versions.CICERONE
import Versions.CONSTRAINT_LAYOUT
import Versions.CORE_KTX
import Versions.DAGGER
import Versions.ESPRESSO_CORE
import Versions.JUNIT_EXT
import Versions.JUNIT_VERSION
import Versions.KOTLIN
import Versions.MATERIAL
import Versions.TIMBER
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonModulePlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")
        project.plugins.apply("kotlin-android-extensions")

        val androidExtension = project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(30)
                defaultConfig {
                    if (this is AppExtension) {
                        applicationId = "com.maksimnovikov.filmapp"
                    }
                    targetSdkVersion(30)
                    minSdkVersion(21)

                    versionCode = 1
                    versionName = "1.0.0"

                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                // Configure common proguard file settings.
                val proguardFile = "proguard-rules.pro"
                when (this) {
                    is LibraryExtension -> defaultConfig {
                        consumerProguardFiles(proguardFile)
                    }
                    is AppExtension -> buildTypes {
                        getByName("release") {
                            isMinifyEnabled = true
                            isShrinkResources = true
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                proguardFile
                            )
                        }
                    }
                }

                // Java 8
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = "1.8"
                    }
                }
            }
            val lowCase = if (androidExtension is AppExtension) "implementation" else "compileOnly"
            val upperCase = lowCase.capitalize()
            project.dependencies {
                add(lowCase, "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN")
                add(lowCase, "androidx.core:core-ktx:$CORE_KTX")
                add(lowCase, "androidx.appcompat:appcompat:$APPCOMPAT")
                add(lowCase, "com.google.android.material:material:$MATERIAL")
                add(lowCase, "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT")
                add("test${upperCase}", "junit:junit:$JUNIT_VERSION")

                // Cicerone
                add(lowCase, "com.github.terrakok:cicerone:$CICERONE")

                // Dagger
                add("kapt", "com.google.dagger:dagger-android-processor:$DAGGER")
                add("kapt", "com.google.dagger:dagger-compiler:$DAGGER")
                add(lowCase, "com.google.dagger:dagger:$DAGGER")
                add(lowCase, "com.google.dagger:dagger-android-support:$DAGGER")
                add(lowCase, "com.google.dagger:dagger-android:$DAGGER")

                // Timber
                add(lowCase, "com.jakewharton.timber:timber:$TIMBER")

                add("androidTest${upperCase}", "androidx.test.ext:junit:$JUNIT_EXT")
                add(
                    "androidTest${upperCase}",
                    "androidx.test.espresso:espresso-core:$ESPRESSO_CORE"
                )
            }
        }
    }
}