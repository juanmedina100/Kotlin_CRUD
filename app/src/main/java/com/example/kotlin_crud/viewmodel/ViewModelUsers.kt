package com.example.kotlin_crud.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_crud.model.UsersModel
import com.example.kotlin_crud.repository.RepositoryUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelUsers @Inject constructor(private val repositoryUser: RepositoryUser) :ViewModel() {

    fun getAllUser():LiveData<List<UsersModel>>{
        return repositoryUser.getAllUser()
    }
    fun insertUser(usersModel: UsersModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryUser.insertUser(usersModel)
        }
    }
    fun updateUser(usersModel: UsersModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryUser.updateUser(usersModel)
        }
    }
    fun deleteUser(usersModel: UsersModel){
        viewModelScope.launch(Dispatchers.IO) {
            repositoryUser.deleteUser(usersModel)
        }
    }
}