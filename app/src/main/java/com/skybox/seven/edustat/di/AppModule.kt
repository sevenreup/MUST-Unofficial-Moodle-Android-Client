package com.skybox.seven.edustat.di

import android.content.Context
import com.google.gson.GsonBuilder
import com.skybox.seven.edustat.api.MoodleInterceptor
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesMoodleOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun providesMoodleService(client: OkHttpClient): MoodleService {
        val retrofit = Retrofit.Builder().client(client).baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
        return retrofit.create(MoodleService::class.java)
    }
    @Provides
    fun provideDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun getPreferences(@ApplicationContext context: Context): PrefRepository = PrefRepository(context.getSharedPreferences(PrefRepository.PREFS, Context.MODE_PRIVATE))
}