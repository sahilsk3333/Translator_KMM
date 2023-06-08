package me.iamsahil.translator_kmm.android.voice_to_text.di

import android.app.Application
import me.iamsahil.translator_kmm.android.voice_to_text.data.AndroidVoiceToTextParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import me.iamsahil.translator_kmm.voice_to_text.domain.VoiceToTextParser

@Module
@InstallIn(ViewModelComponent::class)
object VoiceToTextModule {

    @Provides
    @ViewModelScoped
    fun provideVoiceToTextParser(app: Application): VoiceToTextParser {
        return AndroidVoiceToTextParser(app)
    }
}