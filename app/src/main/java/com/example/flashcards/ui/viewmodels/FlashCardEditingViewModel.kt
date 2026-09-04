package com.example.flashcards.ui.viewmodels

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.flashcards.domain.models.FlashCard
import com.example.flashcards.domain.repositories.FlashCardRepository
import com.example.flashcards.ui.events.FlashCardEditingEvent
import com.example.flashcards.ui.navigation.destinations.FlashCardEditing
import com.example.flashcards.ui.states.FlashCardEditingUiState
import com.example.flashcards.ui.states.FlashCardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FlashCardEditingViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val flashCardRepository: FlashCardRepository
) : ViewModel() {
    private val id = savedStateHandle.toRoute<FlashCardEditing>().id
    private val _uiState = MutableStateFlow(FlashCardEditingUiState())
    val uiState: StateFlow<FlashCardEditingUiState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            println(id)
            val flashCard = flashCardRepository.getFlashCardById(id)
            println(flashCard)
            if (flashCard != null) {
                _uiState.value = _uiState.value.copy(
                    flashCardState = FlashCardState(
                        title = TextFieldState(flashCard.title),
                        front = TextFieldState(flashCard.front),
                        back = TextFieldState(flashCard.back)
                    )
                )
            }
        }
    }

    fun onEvent(event: FlashCardEditingEvent) {
        when(event) {
            FlashCardEditingEvent.OnDoneButtonClicked -> viewModelScope.launch(Dispatchers.IO) {
                with(uiState.value.flashCardState) {
                    flashCardRepository.createFlashCard(
                        FlashCard(
                            id = id,
                            title = title.text.toString(),
                            front = front.text.toString(),
                            back = back.text.toString()
                        )
                    )
                }
            }
        }
    }
}