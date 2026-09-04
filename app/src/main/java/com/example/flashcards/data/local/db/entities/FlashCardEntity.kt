package com.example.flashcards.data.local.db.entities

import androidx.room3.ColumnInfo
import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.example.flashcards.domain.models.FlashCard

@Entity(tableName = "flash_card")
data class FlashCardEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "creation_date", defaultValue = "CURRENT_TIMESTAMP") val creationDate: String = "",
    @ColumnInfo(name = "front") val front: String,
    @ColumnInfo(name = "back") val back: String
)

fun FlashCardEntity.toModel(): FlashCard {
    return FlashCard(
        id = this.id,
        title = this.title,
        creationDate = this.creationDate,
        front = this.front,
        back = this.back
    )
}

fun FlashCard.toEntity(): FlashCardEntity {
    return FlashCardEntity(
        id = this.id,
        title = this.title,
        front = this.front,
        back = this.back
    )
}