package com.example.flashcards.ui.navigation.destinations

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.flashcards.ui.screens.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

fun NavGraphBuilder.homeScreen() {
    composable<Home> {
        HomeScreen()
    }
}

fun NavController.navigateToHome() {
    this.navigate(Home)
}