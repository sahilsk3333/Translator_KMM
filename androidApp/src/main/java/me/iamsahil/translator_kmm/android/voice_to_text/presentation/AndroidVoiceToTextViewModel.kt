package me.iamsahil.translator_kmm.android.voice_to_text.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import me.iamsahil.translator_kmm.voice_to_text.domain.VoiceToTextParser
import me.iamsahil.translator_kmm.voice_to_text.presentation.VoiceToTextEvent
import me.iamsahil.translator_kmm.voice_to_text.presentation.VoiceToTextViewModel
import javax.inject.Inject

@HiltViewModel
class AndroidVoiceToTextViewModel @Inject constructor(
    private val parser: VoiceToTextParser
): ViewModel() {

    private val viewModel by lazy {
        VoiceToTextViewModel(
            parser = parser,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: VoiceToTextEvent) {
        viewModel.onEvent(event)
    }
}