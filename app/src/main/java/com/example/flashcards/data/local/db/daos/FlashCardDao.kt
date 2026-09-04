package com.example.flashcards.data.local.db.daos

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.OnConflictStrategy
import androidx.room3.Query
import com.example.flashcards.data.local.db.entities.FlashCardEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FlashCardDao {
    @Query("SELECT * FROM flash_card WHERE id = :id")
    suspend fun getFlashCardById(id: Long): FlashCardEntity?

    @Query("SELECT * FROM flash_card")
    fun getFlashCards(): Flow<List<FlashCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlashCard(flashCard: FlashCardEntity): Long

    @Delete
    suspend fun deleteFlashCard(flashCard: FlashCardEntity): Int

    @Query("DELETE FROM flash_card WHERE id = :id")
    suspend fun deleteFlashCardById(id: Long): Int
}