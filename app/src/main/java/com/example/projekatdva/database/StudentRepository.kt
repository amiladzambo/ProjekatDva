package com.example.projekatdva.database

import androidx.lifecycle.LiveData

class StudentRepository(private val studentDAO: StudentDAO) {
    val readAllData : LiveData<List<Student>> =  studentDAO.readStudentTable()
    suspend  fun addStudent(student: Student) {
        studentDAO.addStudent(student)
    }
}