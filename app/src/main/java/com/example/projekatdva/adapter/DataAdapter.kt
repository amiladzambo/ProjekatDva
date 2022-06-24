package com.example.projekatdva.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projekatdva.DataListDirections
import com.example.projekatdva.R
import com.example.projekatdva.model.StudentItem


class DataAdapter(private val characterList: ArrayList<StudentItem>) :
    RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.data_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = characterList[position]
        holder.character.text = currentItem.name
        holder.itemView.setOnClickListener {view ->
            val action = DataListDirections.actionDataListToDataDetails(currentItem)
            view.findNavController().navigate(action)
        }
    }
    override fun getItemCount(): Int {
        return characterList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val character: TextView = itemView.findViewById(R.id.character)
    }
}


