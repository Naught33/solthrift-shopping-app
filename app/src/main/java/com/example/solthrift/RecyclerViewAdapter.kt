package com.example.solthrift

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RecyclerViewAdapter(val newList: ArrayList<UploadItems>): Adapter<RecyclerViewAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
var name = itemView.findViewById<TextView>(R.id.fname)
var description = itemView.findViewById<TextView>(R.id.description_)
var price = itemView.findViewById<TextView>(R.id.price_)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.good,parent,false)
        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currItem = newList[position]
        holder.name.text = currItem.name
        holder.description.text = currItem.description
        holder.price.text = currItem.price

    }

    override fun getItemCount(): Int {
return newList.size
    }
}