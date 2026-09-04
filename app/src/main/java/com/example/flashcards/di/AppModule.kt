package com.example.flashcards.di

import android.content.Context
import androidx.room3.Room
import com.example.flashcards.data.local.db.FlashCardDatabase
import com.example.flashcards.data.repositories.FlashCardRepositoryImpl
import com.example.flashcards.domain.repositories.FlashCardRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideFlashCardDatabase(
        @ApplicationContext context: Context
    ): FlashCardDatabase {
        //return Room.databaseBuilder(
        //    context,
        //    FlashCardDatabase::class.java,
        //    "flash_card_db",
        //).build()
        return Room.inMemoryDatabaseBuilder(
            context,
            FlashCardDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideFlashCardRepository(
        db: FlashCardDatabase
    ): FlashCardRepository {
        return FlashCardRepositoryImpl(
            flashCardDao = db.flashCardDao()
        )
    }
}