object Versions {

    const val KOTLIN = "1.4.10"
    const val CORE_KTX = "1.3.2"
    const val APPCOMPAT = "1.2.0"
    const val MATERIAL = "1.2.1"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val JUNIT_VERSION = "4.13.1"
    const val JUNIT_EXT = "1.1.2"
    const val ESPRESSO_CORE = "3.3.0"
    const val DAGGER = "2.29.1"
    const val CICERONE = "6.4"
    const val TIMBER = "4.7.1"
}

object Libs {
    object Moshi {

        private const val moshiVersion = "1.10.0"
        const val core = "com.squareup.moshi:moshi:$moshiVersion"
        const val kotlin = "com.squareup.moshi:moshi-kotlin:$moshiVersion"
        const val adapters = "com.squareup.moshi:moshi-adapters:$moshiVersion"
    }

    object Retrofit {

        private const val retrofitVersion = "2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
        const val core = "com.squareup.retrofit2:retrofit:$retrofitVersion"
        const val coroutinesAdapter =
            "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
    }
}