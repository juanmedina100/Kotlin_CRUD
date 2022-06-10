package com.example.kotlin_crud.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UsersModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val User:String,
    val Name:String
)
