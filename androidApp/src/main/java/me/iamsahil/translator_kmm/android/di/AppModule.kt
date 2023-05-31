package me.iamsahil.translator_kmm.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import me.iamsahil.translator_kmm.database.TranslateDatabase
import me.iamsahil.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import me.iamsahil.translator_kmm.translate.data.local.DatabaseDriverFactory
import me.iamsahil.translator_kmm.translate.data.remote.HttpClientFactory
import me.iamsahil.translator_kmm.translate.data.translate.KtorTranslateClient
import me.iamsahil.translator_kmm.translate.domain.history.HistoryDataSource
import me.iamsahil.translator_kmm.translate.domain.translate.Translate
import me.iamsahil.translator_kmm.translate.domain.translate.TranslateClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}