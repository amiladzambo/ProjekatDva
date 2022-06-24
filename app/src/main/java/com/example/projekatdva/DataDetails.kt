package com.example.projekatdva

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.example.projekatdva.databinding.FragmentDataDetailsBinding
import com.example.projekatdva.model.StudentItem


class DataDetails : Fragment() {
    private var _binding: FragmentDataDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        val args: DataDetailsArgs by navArgs()
        val characterName = args.character

        binding.characterName.text = characterName.name
        binding.actorName.text = characterName.actor
        binding.ancestyValue.text = characterName.ancestry

        binding.saveDataButton.setOnClickListener {
            Toast.makeText(context, "CLCIKED", Toast.LENGTH_SHORT).show()
        }

        return view
    }

}