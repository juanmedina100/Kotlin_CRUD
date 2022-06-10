package com.example.kotlin_crud.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.kotlin_crud.model.UsersModel

@Dao
interface UsersDao {

    @Query("select * from UsersModel")
    fun getAllUser():LiveData<List<UsersModel>>
    @Insert
    suspend fun insertUser(usersModel: UsersModel)
    @Update
    suspend fun updateUser(usersModel: UsersModel)
    @Delete
    suspend fun deleteUser(usersModel: UsersModel)
}