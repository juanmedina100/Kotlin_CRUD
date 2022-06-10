package com.example.kotlin_crud.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.kotlin_crud.dao.UsersDao
import com.example.kotlin_crud.model.UsersModel

@Database(entities = [UsersModel::class], version = 1)
abstract class DatabaseUser:RoomDatabase() {
    abstract fun dao():UsersDao
}