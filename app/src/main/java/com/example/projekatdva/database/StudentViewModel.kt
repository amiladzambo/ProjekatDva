package com.example.projekatdva.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StudentViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<Student>>
    private val repository : StudentRepository
    init {
        val userDAO = StudentDatabase.getDatabase(application).userDao()
        repository = StudentRepository(userDAO)
        readAllData = repository.readAllData
    }
    fun addUser(student: Student) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addStudent(student)
        }
    }
}