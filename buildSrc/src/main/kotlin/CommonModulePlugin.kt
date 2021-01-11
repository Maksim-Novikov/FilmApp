import Versions.kotlin
import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.add
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.exclude
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
                buildFeatures.viewBinding = true
                // Configure common proguard file settings.
                val proguardFile = "proguard-rules.pro"
                when (this) {
                    is LibraryExtension -> {
                        defaultConfig {
                            consumerProguardFiles(proguardFile)
                        }
                    }

                    is AppExtension -> {
                        buildTypes {
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
            val androidTest = "androidTest${capitalize}"
            val test = "test${capitalize}"
            val kapt = "kapt"
            val debug = "debug$capitalize"

            project.dependencies {
                add(implement, "org.jetbrains.kotlin:kotlin-stdlib:$kotlin")
                add(implement, Libs.Coroutines.core)
                add(implement, Libs.AndroidX.contraint)
                add(implement, Libs.AndroidX.recyclerView)
                add(implement, Libs.AndroidX.appCompat)
                add(implement, Libs.AndroidX.material)
                add(implement, Libs.AndroidX.coreKtx)
                add(implement, Libs.AndroidX.fragmentKtx)
                add(implement, Libs.AndroidX.multiDex)
                add(implement, Libs.AndroidX.lifecycleViewmodelKtx)
                add(implement, Libs.AndroidX.lifecycleRuntimeKtx)

                add(implement, Libs.UI.delegateAdapterCore)
                add(implement, Libs.UI.delegateAdapterViewBiding)
                add(implement, Libs.UI.viewBindingUtils)

                add(implement, Libs.Cicerone.core)

                // Dagger
                add(implement, Libs.Dagger.dagger)
                add(implement, Libs.Dagger.androidSupport)
                add(implement, Libs.Dagger.android)
                add(kapt, Libs.Dagger.kaptProcessor)
                add(kapt, Libs.Dagger.kaptCompiler)

                // Timber
                add(implement, Libs.Logger.timber)

                add(implement, Libs.Moshi.core)
                add(implement, Libs.Moshi.adapters)
                add("kapt", Libs.Moshi.codegen)

                add(implement, Libs.Retrofit.loggingInterceptor)
                add(implement, Libs.Retrofit.core)
                add(implement, Libs.Retrofit.coroutinesAdapter)
                add(implement, Libs.Retrofit.converterMoshi)


                add(implement, Libs.Glide.core)
                add(kapt, Libs.Glide.compiler)
                add(implement, Libs.Glide.okhttp3Integration) {
                    exclude(group = "glide-parent")
                }


                add(androidTest, Libs.Test.espresso)
                add(androidTest, Libs.Test.testRunner)
                add(androidTest, Libs.Test.testCore)
                add(androidTest, Libs.Test.testExtJunit)
                add(androidTest, Libs.Test.testRules)
                add(test, Libs.Test.kotlinTestCore)
                add(test, Libs.Test.kotlinTestAssertions)
                add(test, Libs.Test.kotlinTestRunnerJunit5)
                add(test, Libs.Test.junit)
                add(test, Libs.Test.mockitoCore)
                add(test, Libs.Test.mockitoInline)
                add(test, Libs.Test.robolectric)
                add("api", Libs.Test.guava)
            }
        }
    }
}