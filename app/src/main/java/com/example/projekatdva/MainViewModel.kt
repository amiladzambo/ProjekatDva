package com.example.projekatdva

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projekatdva.model.StudentItem
import com.example.projekatdva.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    var gryffindor : MutableLiveData<List<StudentItem>> = MutableLiveData()
    var slytherin : MutableLiveData<List<StudentItem>> = MutableLiveData()
    var hufflepuff : MutableLiveData<List<StudentItem>> = MutableLiveData()
    var ravenclaw : MutableLiveData<List<StudentItem>> = MutableLiveData()

    fun getGryffindor() {
        viewModelScope.launch {
            val response: List<StudentItem> = repository.getGryffindor()
            gryffindor.value = response
        }
    }
    fun getSlytherin() {
        viewModelScope.launch {
            val response: List<StudentItem> = repository.getSlytherin()
            slytherin.value = response
        }
    }
    fun getHufflepuff() {
        viewModelScope.launch {
            val response: List<StudentItem> = repository.getHufflepuff()
            hufflepuff.value = response
        }
    }
    fun getRavenclaw() {
        viewModelScope.launch {
            val response: List<StudentItem> = repository.getRavenclaw()
            ravenclaw.value = response
        }
    }
}