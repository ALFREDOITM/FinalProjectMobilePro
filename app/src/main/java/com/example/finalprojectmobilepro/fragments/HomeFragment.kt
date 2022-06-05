package com.example.finalprojectmobilepro.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalprojectmobilepro.R
import com.example.finalprojectmobilepro.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        val navController = findNavController()
        binding.inButton.setOnClickListener{
            val temp = binding.radio.checkedRadioButtonId.toString()
            Toast.makeText(context,temp, Toast.LENGTH_SHORT).show()
            navController.navigate(R.id.action_homeFragment_to_insideHome)
        }

        return binding.root
    }

}