package com.example.projekatdva

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.projekatdva.databinding.FragmentHomeBinding
import com.example.projekatdva.repository.Repository


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.gryffindor.setOnClickListener {
          val action = HomeFragmentDirections.actionHomeFragmentToDataList("gryffindor");
            view.findNavController().navigate(action)
        }
        binding.slytherin.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDataList("slytherin");
            view.findNavController().navigate(action)
        }
        binding.hufflepuff.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDataList("hufflepuff");
            view.findNavController().navigate(action)
        }
        binding.ravenclaw.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDataList("ravenclaw");
            view.findNavController().navigate(action)
        }
        return view
    }
}