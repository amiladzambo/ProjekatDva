package com.example.projekatdva

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.GridView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projekatdva.adapter.DataAdapter
import com.example.projekatdva.databinding.FragmentDataListBinding
import com.example.projekatdva.model.StudentItem
import com.example.projekatdva.repository.Repository

class DataList : Fragment() {
    private var _binding: FragmentDataListBinding? = null
    private val binding get() = _binding!!

    private lateinit var newRecyclerview: RecyclerView
    private lateinit var viewModel: MainViewModel
    private lateinit var  characterList: ArrayList<StudentItem>
    private lateinit var  imagesSrcList: ArrayList<String>
    private  lateinit var value: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.my_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.gallery -> {
                val intent = Intent(context, GalleryActivity::class.java);
                startActivity(intent);
            }
            R.id.database -> {
                val intent = Intent(context, DatabaseList::class.java);
                startActivity(intent);
            }
            else -> Toast.makeText(context, "Gallery", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataListBinding.inflate(inflater, container, false)
        val view = binding.root

        val arg: DataListArgs by navArgs()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        newRecyclerview = binding.recyclerViewDataList
        newRecyclerview.layoutManager = LinearLayoutManager(activity)
        newRecyclerview.setHasFixedSize(true)
        characterList = arrayListOf()
        imagesSrcList = arrayListOf()

        when (val house = arg.house) {
            "gryffindor" -> {
                value = "gryffindor"
                viewModel.getGryffindor()
                viewModel.gryffindor.observe(viewLifecycleOwner, Observer { response ->
                    for (res in response) {
                        characterList.add(res)
                        imagesSrcList.add(res.image)
                        Log.i("ResponseData", characterList.size.toString())
                    }
                    newRecyclerview.adapter = DataAdapter(characterList)
                })
            }
            "slytherin" -> {
                value = "slytherin"
                viewModel.getSlytherin()
                viewModel.slytherin.observe(viewLifecycleOwner, Observer { response ->
                    for (res in response) {
                        characterList.add(res)
                        imagesSrcList.add(res.image)
                        Log.i("ResponseData", res.name)
                    }
                    Log.i("IMAGES", imagesSrcList[0])
                    newRecyclerview.adapter = DataAdapter(characterList)
                })
            }
            "hufflepuff" -> {
                value = "hufflepuff"
                viewModel.getHufflepuff()
                viewModel.hufflepuff.observe(viewLifecycleOwner, Observer { response ->
                    for (res in response) {
                        characterList.add(res)
                        imagesSrcList.add(res.image)
                        Log.i("ResponseData", res.name)
                    }
                    newRecyclerview.adapter = DataAdapter(characterList)
                })
            }
            "ravenclaw" -> {
                value = "ravenclaw"
                viewModel.getRavenclaw()
                viewModel.ravenclaw.observe(viewLifecycleOwner, Observer { response ->
                    for (res in response) {
                        characterList.add(res)
                        imagesSrcList.add(res.image)
                        Log.i("ResponseData", res.name)
                    }
                    newRecyclerview.adapter = DataAdapter(characterList)
                })
            }
            else -> Toast.makeText(context, "Choose a house", Toast.LENGTH_SHORT).show()

        }
        return view
    }





}