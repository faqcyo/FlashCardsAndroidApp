package com.example.flashcards.data.repositories

import com.example.flashcards.data.local.db.daos.FlashCardDao
import com.example.flashcards.data.local.db.entities.toEntity
import com.example.flashcards.data.local.db.entities.toModel
import com.example.flashcards.domain.models.FlashCard
import com.example.flashcards.domain.repositories.FlashCardRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FlashCardRepositoryImpl @Inject constructor(
    private val flashCardDao: FlashCardDao
) : FlashCardRepository {
    override fun getFlashCards(): Flow<List<FlashCard>> {
        return flashCardDao.getFlashCards().map { entities ->
            entities.map { entity ->
                entity.toModel()
            }
        }
    }
    override suspend fun getFlashCardById(id: Long): FlashCard? {
        println(id)
        val flashCardEntity = flashCardDao.getFlashCardById(id)
        println(flashCardEntity)
        return flashCardEntity?.toModel()
    }

    override suspend fun createFlashCard(flashCard: FlashCard): Long {
        return flashCardDao.insertFlashCard(flashCard.toEntity())
    }

    override suspend fun deleteFlashCard(flashCard: FlashCard): Int {
        return flashCardDao.deleteFlashCard(flashCard.toEntity())
    }
    override suspend fun deleteFlashCardById(id: Long): Int {
        return flashCardDao.deleteFlashCardById(id)
    }
}