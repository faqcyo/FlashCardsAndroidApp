package com.example.flashcards.domain.repositories

import com.example.flashcards.domain.models.FlashCard
import kotlinx.coroutines.flow.Flow

interface FlashCardRepository {
    fun getFlashCards(): Flow<List<FlashCard>>
    suspend fun getFlashCardById(id: Long): FlashCard

    suspend fun createFlashCard(flashCard: FlashCard): Long // Returns the id of the new entry

    suspend fun deleteFlashCard(flashCard: FlashCard): Int // Returns the amount of entries deleted
    suspend fun deleteFlashCardById(id: Long): Int
}