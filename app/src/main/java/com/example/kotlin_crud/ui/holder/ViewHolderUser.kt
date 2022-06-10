package com.example.kotlin_crud.ui.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud.databinding.ItemMainBinding
import com.example.kotlin_crud.model.UsersModel

class ViewHolderUser(itemView: View) :RecyclerView.ViewHolder(itemView) {
    val binding = ItemMainBinding.bind(itemView)
    fun render(usersModel: UsersModel,DeleteItem:(UsersModel)->Unit,EditItem:(UsersModel)->Unit){
        binding.txtUser.text = usersModel.User
        binding.txtName.text = usersModel.Name
        binding.btnDelete.setOnClickListener { DeleteItem(usersModel) }
        binding.btnEdit.setOnClickListener { EditItem(usersModel) }
    }
}