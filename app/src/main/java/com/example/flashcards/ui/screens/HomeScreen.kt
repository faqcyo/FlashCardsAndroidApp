package com.example.flashcards.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.flashcards.R
import com.example.flashcards.ui.events.HomeEvent
import com.example.flashcards.ui.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToFlashCardEditingScreen: (Long) -> Unit
) {
    val flashCards = viewModel.flashCards.collectAsState()
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
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {
            items(flashCards.value) { flashCard ->
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                        .clickable {
                            navigateToFlashCardEditingScreen(flashCard.id)
                        }
                ) {
                    Column {
                        Text(flashCard.id.toString())
                        Text(flashCard.title)
                        Text(flashCard.front)
                        Text(flashCard.back)
                    }
                    IconButton(
                        onClick = { viewModel.onEvent(HomeEvent.OnFlashCardDeleteButtonClicked(flashCard.id)) }
                    ) {
                        Icon(painterResource(R.drawable.ic_delete), "Delete flash card")
                    }
                }
            }
        }
    }
}