package com.example.flashcards.ui.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.flashcards.ui.screens.FlashCardEditingScreen
import kotlinx.serialization.Serializable

@Serializable
data class FlashCardEditing(val id: Long)

fun NavGraphBuilder.flashCardEditingScreen(
    navigateBack: () -> Unit
) {
    composable<FlashCardEditing> {
        FlashCardEditingScreen(
            navigateBack = navigateBack
        )
    }
}

fun NavController.navigateToFlashCardEditing(id: Long) {
    this.navigate(FlashCardEditing(id))
}