package me.iamsahil.translator_kmm.translate.domain.translate

import me.iamsahil.translator_kmm.core.domain.language.Language

interface TranslateClient {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): String
}