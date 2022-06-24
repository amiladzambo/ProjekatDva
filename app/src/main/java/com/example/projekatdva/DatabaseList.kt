package com.example.projekatdva

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projekatdva.adapter.DatabaseAdapter
import com.example.projekatdva.database.StudentViewModel
import com.example.projekatdva.model.StudentItem

class DatabaseList : AppCompatActivity() {
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var  characterList: ArrayList<String>
    private lateinit var mStudentViewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database_list)

        newRecyclerview = findViewById(R.id.databaseRecyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        characterList = arrayListOf()

        mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
        mStudentViewModel.readAllData.observe(this, Observer { students ->
           for(student in students) {
               characterList.add(student.name)
           }
            newRecyclerview.adapter = DatabaseAdapter(characterList)
        })
    }


}