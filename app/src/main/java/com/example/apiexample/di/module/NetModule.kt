package com.example.apiexample.di.module

import com.example.apiexample.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetModule {

    companion object {
        private const val NAME_LOGGING = "LoggingInterceptor"
        private const val NAME_AUTH = "AuthInterceptor"
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory =
        RxJava2CallAdapterFactory.create()

    @Provides
    @Singleton
    @Named(NAME_AUTH)
    fun provideAuthInterceptor(): Interceptor = Interceptor {
        val newUrl = it.request().url().newBuilder()
            .addQueryParameter("apiKey", BuildConfig.API_KEY)
            .build()
        val newRequest = it.request().newBuilder().url(newUrl).build()
        it.proceed(newRequest)
    }

    @Provides
    @Singleton
    @Named(NAME_LOGGING)
    fun provideLoggingInterceptor(): Interceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named(NAME_AUTH) authInterceptor: Interceptor,
        @Named(NAME_LOGGING) loggingInterceptor: Interceptor
    ): OkHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(authInterceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        client: OkHttpClient,
        converterFactory: GsonConverterFactory,
        callAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BuildConfig.API_ENDPOINT)
        .addConverterFactory(converterFactory)
        .addCallAdapterFactory(callAdapterFactory)
        .build()
}
