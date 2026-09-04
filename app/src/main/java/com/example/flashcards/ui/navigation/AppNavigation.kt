package com.example.flashcards.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.flashcards.ui.navigation.destinations.Home
import com.example.flashcards.ui.navigation.destinations.flashCardEditingScreen
import com.example.flashcards.ui.navigation.destinations.homeScreen
import com.example.flashcards.ui.navigation.destinations.navigateToFlashCardEditing

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold() { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            homeScreen(
                navigateToFlashCardEditingScreen = { navController.navigateToFlashCardEditing(it) }
            )
            flashCardEditingScreen(
                navigateBack = navController::popBackStack
            )
        }
    }
}