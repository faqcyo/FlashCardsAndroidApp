package com.example.flashcards.domain.models

data class FlashCard(
    val id: Long = 0,
    val title: String,
    val creationDate: String = "",
    val front: String,
    val back: String
)