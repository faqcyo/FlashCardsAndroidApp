package com.example.flashcards.ui.states

import androidx.compose.foundation.text.input.TextFieldState

data class FlashCardEditingUiState(
    val flashCardState: FlashCardState = FlashCardState()
)

data class FlashCardState(
    val title: TextFieldState = TextFieldState(""),
    val front: TextFieldState = TextFieldState(""),
    val back: TextFieldState = TextFieldState("")
)