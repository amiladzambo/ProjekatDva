package com.example.projekatdva.repository

import com.example.projekatdva.api.RetrofitInstance
import com.example.projekatdva.model.StudentItem

class Repository {
    suspend fun getGryffindor() : List<StudentItem> {
        return RetrofitInstance.api.getGryffindor()
    }
    suspend fun getSlytherin() : List<StudentItem> {
        return RetrofitInstance.api.getSlytherin()
    }
    suspend fun getHufflepuff() : List<StudentItem> {
        return RetrofitInstance.api.getHufflepuff()
    }
    suspend fun getRavenclaw() : List<StudentItem> {
        return RetrofitInstance.api.getRavenclaw()
    }
}