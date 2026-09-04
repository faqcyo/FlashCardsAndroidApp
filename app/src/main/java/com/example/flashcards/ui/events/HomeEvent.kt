package com.example.flashcards.ui.events

sealed class HomeEvent {
    object OnFlashCardCreateButtonClicked : HomeEvent()
    object OnFolderCreateButtonClicked : HomeEvent()
}