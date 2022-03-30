package com.example.cat

import androidx.room.RoomDatabase

import androidx.room.Database


@Database(entities = [User::class], version = 4)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao?
}