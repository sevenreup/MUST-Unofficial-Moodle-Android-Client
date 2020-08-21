package com.skybox.seven.edustat.di

import android.content.Context
import androidx.room.Room
import com.liulishuo.okdownload.DownloadContext
import com.liulishuo.okdownload.UnifiedListenerManager
import com.skybox.seven.edustat.api.MoodleInterceptor
import com.skybox.seven.edustat.api.MoodleService
import com.skybox.seven.edustat.data.DownloadsDAO
import com.skybox.seven.edustat.data.MoodleDB
import com.skybox.seven.edustat.data.SiteDAO
import com.skybox.seven.edustat.repository.PrefRepository
import com.skybox.seven.edustat.util.Constants
import com.skybox.seven.edustat.util.download.MoodleDownloadListener
import com.skybox.seven.edustat.util.getParentFile
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
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesMoodleOkHttpClient(prefRepository: PrefRepository): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(MoodleInterceptor(prefRepository))
            .build()
    }

    @Singleton
    @Provides
    fun providesMoodleService(client: OkHttpClient): MoodleService {
        val retrofit = Retrofit.Builder().client(client).baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        return retrofit.create(MoodleService::class.java)
    }
    @Provides
    fun provideDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun getPreferences(@ApplicationContext context: Context): PrefRepository = PrefRepository(context.getSharedPreferences(PrefRepository.PREFS, Context.MODE_PRIVATE))

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context): MoodleDB =
        Room.databaseBuilder(context, MoodleDB::class.java,"Moodle_Self_DB")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideSiteDAO(moodleDB: MoodleDB): SiteDAO = moodleDB.siteDAO()

    @Provides
    @Singleton
    fun provideDownloadsDAO(moodleDB: MoodleDB): DownloadsDAO = moodleDB.downloadsDAO()

    @Provides
    @Singleton
    fun providesDownloadBuilder(@ApplicationContext context: Context): DownloadContext.Builder =
        DownloadContext.QueueSet()
            .setParentPathFile(File(getParentFile(context), "moodle_noodle"))
            .setMinIntervalMillisCallbackProcess(300).commit()

    @Provides
    @Singleton
    fun providesDownloadListener() = UnifiedListenerManager()
}