package com.example.kotlin_crud.ui

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_crud.viewmodel.ViewModelUsers
import com.example.kotlin_crud.databinding.ActivityMainBinding
import com.example.kotlin_crud.model.UsersModel
import com.example.kotlin_crud.ui.adapter.AdapterUser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var myList = mutableListOf<UsersModel>()
    val viewModel: ViewModelUsers by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    init()
    binding.btnNew.setOnClickListener {
        val new = Intent(this,NewUser::class.java)
        new.putExtra("id",0)
        new.putExtra("user","")
        new.putExtra("name","")
        startActivity(new)
    }


    }

    private fun init(){
        viewModel.getAllUser().observe(this){
            myList.clear()
            myList = it as MutableList<UsersModel>
            binding.RVUsers.layoutManager = LinearLayoutManager(this)
            binding.RVUsers.adapter=AdapterUser(myList,{DeleteItem(it)},{EditItem(it)})
        }

    }
    fun DeleteItem(usersModel: UsersModel){
        val del=AlertDialog.Builder(this)
        del.setTitle("DELETE")
        del.setMessage("Delete Item?")
        del.setCancelable(false)
        del.setPositiveButton("DELETE",{ dialogInterface: DialogInterface, i: Int ->
            viewModel.deleteUser(usersModel)
        })
        del.setNegativeButton("Cerrar",null)
        del.show()

    }
    fun EditItem(usersModel: UsersModel){
        val new = Intent(this,NewUser::class.java)
        new.putExtra("id",usersModel.id)
        new.putExtra("user",usersModel.User)
        new.putExtra("name",usersModel.Name)
        startActivity(new)
    }
}