package com.example.recyclerviewdatabinding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdatabinding.databinding.UserRowBinding

class MyAdapter(var context: Context,var userlist:List<Model>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(var rowBinding: UserRowBinding) : RecyclerView.ViewHolder(rowBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(DataBindingUtil.
       inflate(LayoutInflater.from(context),R.layout.user_row,parent,false)
       )
    }

    override fun getItemCount()=userlist.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rowBinding.user=userlist[position]
    }
}