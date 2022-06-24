package com.example.projekatdva

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.projekatdva.adapter.DataAdapter
import com.example.projekatdva.adapter.GridAdapter
import com.example.projekatdva.model.StudentItem
import com.example.projekatdva.repository.Repository


class GalleryActivity : AppCompatActivity() {

    private lateinit var newGridView: GridView
    private lateinit var viewModel: MainViewModel
    private lateinit var  imagesSrcList: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        newGridView = findViewById(R.id.galleryView)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        addToList()

        newGridView.adapter = GridAdapter(this, imagesSrcList)

    }
    private fun addToList() {
        imagesSrcList = arrayListOf()
        imagesSrcList.add("https://hp-api.herokuapp.com/images/harry.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/hermione.jpeg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/ron.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/draco.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/snape.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/mcgonagall.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/hagrid.png")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/ginny.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/lupin.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/neville.jpg")
        imagesSrcList.add("https://hp-api.herokuapp.com/images/arthur.jpg")

    }
}