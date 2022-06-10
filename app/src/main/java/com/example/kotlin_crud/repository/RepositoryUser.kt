package com.example.kotlin_crud.repository

import androidx.lifecycle.LiveData
import com.example.kotlin_crud.dao.UsersDao
import com.example.kotlin_crud.model.UsersModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryUser @Inject constructor(private val dao: UsersDao) {

    fun getAllUser():LiveData<List<UsersModel>>{
        return dao.getAllUser()
    }
    suspend fun insertUser(usersModel: UsersModel){
        dao.insertUser(usersModel)
    }
    suspend fun updateUser(usersModel: UsersModel){
        dao.updateUser(usersModel)
    }
    suspend fun deleteUser(usersModel: UsersModel){
        dao.deleteUser(usersModel)
    }
}