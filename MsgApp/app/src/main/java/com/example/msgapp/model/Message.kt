package com.example.msgapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val timesTamp: Long
)