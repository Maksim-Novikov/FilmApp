object Versions {

    const val kotlin = "1.4.10"
}

object Libs {

    object Coroutines {

        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2"
    }

    object AndroidX {

        const val contraint = "androidx.constraintlayout:constraintlayout:2.0.1"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val material = "com.google.android.material:material:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.2.5"
        const val multiDex = "androidx.multidex:multidex:2.0.1"
        const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0"
    }

    object UI {

        const val delegateAdapterCore = "com.hannesdorfmann:adapterdelegates4-kotlin-dsl:4.3.0"
        const val delegateAdapterViewBiding =
            "com.hannesdorfmann:adapterdelegates4-kotlin-dsl-viewbinding:4.3.0"

        const val viewBindingUtils =
            "com.kirich1409.viewbindingpropertydelegate:vbpd-noreflection:1.2.1"
    }

    object Dagger {

        private const val daggerVersion = "2.30.1"
        const val kaptProcessor = "com.google.dagger:dagger-android-processor:$daggerVersion"
        const val kaptCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"
        const val dagger = "com.google.dagger:dagger:$daggerVersion"
        const val androidSupport = "com.google.dagger:dagger-android-support:$daggerVersion"
        const val android = "com.google.dagger:dagger-android:$daggerVersion"
    }

    object Moshi {

        private const val moshiVersion = "1.11.0"
        const val core = "com.squareup.moshi:moshi:$moshiVersion"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val adapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
        const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion"
    }

    object Retrofit {

        private const val retrofitVersion = "2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val coroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }

    object Glide {

        private const val glideVersion = "4.11.0"
        const val core = "com.github.bumptech.glide:glide:$glideVersion"
        const val compiler = "com.github.bumptech.glide:compiler:$glideVersion"
        const val okhttp3Integration = "com.github.bumptech.glide:okhttp3-integration:$glideVersion"
    }


    object Logger {

        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }

    object Cicerone {

        const val core = "com.github.terrakok:cicerone:6.4"
    }

    object Test {

        private const val kotlintestVersion = "3.4.2"
        const val kotlinTestCore = "io.kotlintest:kotlintest-core:$kotlintestVersion"
        const val kotlinTestAssertions = "io.kotlintest:kotlintest-assertions:$kotlintestVersion"
        const val kotlinTestRunnerJunit5 =
            "io.kotlintest:kotlintest-runner-junit5:$kotlintestVersion"
        const val espresso = "androidx.test.espresso:espresso-core:3.3.0"
        const val testRunner = "androidx.test:runner:1.3.0"
        const val testCore = "androidx.test:core:1.3.0"
        const val testExtJunit = "androidx.test.ext:junit:1.1.2"
        const val testRules = "androidx.test:rules:1.3.0"
        const val junit = "junit:junit:4.13"
        const val mockitoCore = "org.mockito:mockito-core:3.5.11"
        const val mockitoInline = "org.mockito:mockito-inline:3.5.11"
        const val robolectric = "org.robolectric:robolectric:4.2.1"
        const val guava = "com.google.guava:guava:27.0.1-android"
    }
}