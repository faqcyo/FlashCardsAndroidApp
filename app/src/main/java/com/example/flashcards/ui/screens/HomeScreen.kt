package com.example.flashcards.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.flashcards.ui.events.HomeEvent
import com.example.flashcards.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column() {
        Row {
            Button(
                onClick = {
                    viewModel.onEvent(HomeEvent.OnFlashCardCreateButtonClicked)
                }
            ) {
                Text("Create card")
            }
            Button(
                onClick = {
                    viewModel.onEvent(HomeEvent.OnFolderCreateButtonClicked)
                }
            ) {
                Text("Create folder")
            }
        }
    }
}