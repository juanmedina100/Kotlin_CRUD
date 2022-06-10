package com.example.kotlin_crud.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_crud.R
import com.example.kotlin_crud.model.UsersModel
import com.example.kotlin_crud.ui.holder.ViewHolderUser

class AdapterUser(private val mList:MutableList<UsersModel>,
private val DeleteItem:(UsersModel)->Unit,
private val EditItem:(UsersModel)->Unit):RecyclerView.Adapter<ViewHolderUser>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        val layout = LayoutInflater.from(parent.context)
        return ViewHolderUser(layout.inflate(R.layout.item_main,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        val item = mList[position]
        holder.render(item,DeleteItem,EditItem)
    }

    override fun getItemCount(): Int {
        return mList.size
    }
}