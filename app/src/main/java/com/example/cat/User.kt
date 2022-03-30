package com.example.cat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "accounts",
)
data class User(
    @PrimaryKey(autoGenerate = true) val id :Int,
    val name:String,
    val date: String,
    val score: String
)
