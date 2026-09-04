package com.example.flashcards.ui.events

sealed class FlashCardEditingEvent {
    object OnDoneButtonClicked : FlashCardEditingEvent()
}