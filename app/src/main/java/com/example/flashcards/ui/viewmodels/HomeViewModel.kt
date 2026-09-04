package com.example.flashcards.ui.viewmodels

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flashcards.domain.models.FlashCard
import com.example.flashcards.domain.repositories.FlashCardRepository
import com.example.flashcards.ui.events.HomeEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val flashCardRepository: FlashCardRepository
) : ViewModel() {
    val flashCards = flashCardRepository.getFlashCards().stateIn(
        viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList()
    )

    init {

    }

    fun onEvent(event: HomeEvent) {
        when(event) {
            HomeEvent.OnFlashCardCreateButtonClicked -> viewModelScope.launch(Dispatchers.IO) {
                val flashCard = FlashCard(
                    title = "test",
                    front = "front test",
                    back = "back test"
                )
                flashCardRepository.createFlashCard(flashCard)
            }
            HomeEvent.OnFolderCreateButtonClicked -> {
            }
        }
    }
}