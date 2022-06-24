package com.example.projekatdva.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.projekatdva.DataListDirections
import com.example.projekatdva.R
import com.example.projekatdva.database.Student

class DatabaseAdapter(private val studentList : ArrayList<String>) :
RecyclerView.Adapter<DatabaseAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.data_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.student.text = currentItem
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val student: TextView = itemView.findViewById(R.id.character)
    }
}