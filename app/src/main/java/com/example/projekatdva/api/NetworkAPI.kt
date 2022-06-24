package com.example.projekatdva.api

import com.example.projekatdva.model.StudentItem
import retrofit2.http.GET

interface NetworkAPI {

    @GET("/api/characters/house/gryffindor")
    suspend fun getGryffindor() : List<StudentItem>

    @GET("/api/characters/house/slytherin")
    suspend fun getSlytherin() : List<StudentItem>

    @GET("/api/characters/house/hufflepuff")
    suspend fun getHufflepuff() : List<StudentItem>

    @GET("/api/characters/house/ravenclaw")
    suspend fun getRavenclaw() : List<StudentItem>

}