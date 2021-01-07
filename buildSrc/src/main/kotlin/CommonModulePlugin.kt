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

        val androidRootExtensions = project.extensions.getByName("android")
        if (androidRootExtensions is BaseExtension) {
            androidRootExtensions.apply {
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
            // we don't need implement dependencies in libraries modules
            val implement =
                if (androidRootExtensions is AppExtension) "implementation" else "compileOnly"
            val capitalize = implement.capitalize()
            project.dependencies {
                add(implement, "org.jetbrains.kotlin:kotlin-stdlib:$KOTLIN")
                add(implement, "androidx.core:core-ktx:$CORE_KTX")
                add(implement, "androidx.appcompat:appcompat:$APPCOMPAT")
                add(implement, "com.google.android.material:material:$MATERIAL")
                add(implement, "androidx.constraintlayout:constraintlayout:$CONSTRAINT_LAYOUT")
                add("test${capitalize}", "junit:junit:$JUNIT_VERSION")

                // Cicerone
                add(implement, "com.github.terrakok:cicerone:$CICERONE")

                // Dagger
                add("kapt", "com.google.dagger:dagger-android-processor:$DAGGER")
                add("kapt", "com.google.dagger:dagger-compiler:$DAGGER")
                add(implement, "com.google.dagger:dagger:$DAGGER")
                add(implement, "com.google.dagger:dagger-android-support:$DAGGER")
                add(implement, "com.google.dagger:dagger-android:$DAGGER")

                // Timber
                add(implement, "com.jakewharton.timber:timber:$TIMBER")

                add("androidTest${capitalize}", "androidx.test.ext:junit:$JUNIT_EXT")
                add(
                    "androidTest${capitalize}",
                    "androidx.test.espresso:espresso-core:$ESPRESSO_CORE"
                )

                add(implement, Libs.Moshi.core)
                add(implement, Libs.Moshi.kotlin)
                add(implement, Libs.Moshi.adapters)

                add(implement, Libs.Retrofit.loggingInterceptor)
                add(implement, Libs.Retrofit.core)
                add(implement, Libs.Retrofit.coroutinesAdapter)
                add(implement, Libs.Retrofit.converterMoshi)

            }
        }
    }
}