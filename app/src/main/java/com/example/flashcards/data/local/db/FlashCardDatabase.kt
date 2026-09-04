package com.example.flashcards.data.local.db

import androidx.room3.Database
import androidx.room3.RoomDatabase
import com.example.flashcards.data.local.db.daos.FlashCardDao
import com.example.flashcards.data.local.db.entities.FlashCardEntity

@Database(
    entities = [FlashCardEntity::class],
    version = 1
)
abstract class FlashCardDatabase : RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
}