package com.example.cat

import androidx.room.*
import io.reactivex.Flowable


@Dao
interface UserDao {
    @Query("SELECT * FROM accounts")
    fun getAll(): List<User?>?

    @Query("SELECT * FROM accounts WHERE id = :id")
    fun getById(id: Long): User?

    @Insert
    fun insert(employee: User?)

    @Update
    fun update(employee: User?)

    @Delete
    fun delete(employee: User?)
}