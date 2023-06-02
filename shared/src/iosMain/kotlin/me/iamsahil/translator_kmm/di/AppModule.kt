package me.iamsahil.translator_kmm.di

import me.iamsahil.translator_kmm.database.TranslateDatabase
import me.iamsahil.translator_kmm.translate.data.history.SqlDelightHistoryDataSource
import me.iamsahil.translator_kmm.translate.data.local.DatabaseDriverFactory
import me.iamsahil.translator_kmm.translate.data.remote.HttpClientFactory
import me.iamsahil.translator_kmm.translate.data.translate.KtorTranslateClient
import me.iamsahil.translator_kmm.translate.domain.history.HistoryDataSource
import me.iamsahil.translator_kmm.translate.domain.translate.Translate
import me.iamsahil.translator_kmm.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(
            TranslateDatabase(
                DatabaseDriverFactory().create()
            )
        )
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(
            HttpClientFactory().create()
        )
    }

    val translateUseCase: Translate by lazy {
        Translate(translateClient, historyDataSource)
    }
}