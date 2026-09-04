package com.example.flashcards.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.flashcards.ui.events.FlashCardEditingEvent
import com.example.flashcards.ui.viewmodels.FlashCardEditingViewModel

@Composable
fun FlashCardEditingScreen(
    viewModel: FlashCardEditingViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val uiState = viewModel.uiState.collectAsState()
    Column {
        TextField(
            state = uiState.value.flashCardState.title,
            label = { Text("title") }
        )
        TextField(
            state = uiState.value.flashCardState.front,
            label = { Text("front") }
        )
        TextField(
            state = uiState.value.flashCardState.back,
            label = { Text("back") }
        )
        Button(
            onClick = {
                viewModel.onEvent(FlashCardEditingEvent.OnDoneButtonClicked)
                navigateBack()
            }
        ) {
            Text("Done")
        }
    }
}