package com.example.projekatdva.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StudentDAO {
    @Query("SELECT * FROM STUDENT_TABLE")
    fun readStudentTable(): LiveData<List<Student>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStudent(student: Student)
}