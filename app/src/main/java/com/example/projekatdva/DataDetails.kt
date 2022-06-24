package com.example.projekatdva

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.projekatdva.database.Student
import com.example.projekatdva.database.StudentViewModel
import com.example.projekatdva.databinding.FragmentDataDetailsBinding
import com.example.projekatdva.model.StudentItem


class DataDetails : Fragment() {

    private var _binding: FragmentDataDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var mStudentViewModel: StudentViewModel

    @SuppressLint("QueryPermissionsNeeded")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDataDetailsBinding.inflate(inflater, container, false)
        val view = binding.root

        val args: DataDetailsArgs by navArgs()
        val packageManager = requireActivity().packageManager

        val characterName = args.character

        binding.characterName.text = characterName.name
        binding.actorName.text = characterName.actor
        binding.ancestyValue.text = characterName.ancestry

        binding.saveDataButton.setOnClickListener {
            Toast.makeText(context, "CLCIKED", Toast.LENGTH_SHORT).show()
            mStudentViewModel = ViewModelProvider(this).get(StudentViewModel::class.java)
            val name = characterName.name
            val house = characterName.house
            val actor = characterName.actor
            mStudentViewModel.addUser(Student(0, name, house, actor))
        }

        binding.sendMessageButton.setOnClickListener {
            val sendIntent: Intent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "${characterName.name} was played by ${characterName.actor}")
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(shareIntent)
            }
        }
        return view
    }

}