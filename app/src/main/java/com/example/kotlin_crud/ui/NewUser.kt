package com.example.kotlin_crud.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.kotlin_crud.viewmodel.ViewModelUsers
import com.example.kotlin_crud.databinding.ActivityNewUserBinding
import com.example.kotlin_crud.model.UsersModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewUser : AppCompatActivity() {
    lateinit var binding: ActivityNewUserBinding
    val viewModel: ViewModelUsers by viewModels()
    var id = 0
    var user = ""
    var name = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()



    binding.btnAdd.setOnClickListener {
        if (binding.btnAdd.text=="UPDATE"){
            if (binding.etUser.text.isEmpty() || binding.etName.text.isEmpty()){
                Toast.makeText(this,"Empty",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }else{
                updateUser()
                clear()
            }
        }else{
            if (binding.etUser.text.isEmpty() || binding.etName.text.isEmpty()){
                Toast.makeText(this,"Empty",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            rb()
            clear()
        }
    }
    }
    fun rb(){
        val user=binding.etUser.text.toString()
        val name=binding.etName.text.toString()
        val users = UsersModel(0,user,name)
        viewModel.insertUser(users)
    }
    fun init(){
        val bundle = intent.extras
        id = bundle?.getInt("id").toString().toInt()
        user = bundle?.getString("user").toString()
        name = bundle?.getString("name").toString()
        if (id>0){
            binding.btnAdd.text = "UPDATE"
            binding.etUser.setText(user)
            binding.etName.setText(name)
        }
    }
    fun updateUser(){
        val user_update=UsersModel(id,binding.etUser.text.toString(),binding.etName.text.toString())

        viewModel.updateUser(user_update)
    }
    fun clear(){
        binding.etUser.setText("")
        binding.etName.setText("")
    }
}