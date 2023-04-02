package com.example.quick_cheque.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quick_cheque.R
import com.example.quick_cheque.databinding.FragmentJoinScreenBinding

class JoinScreenFragment : Fragment() {
    private lateinit var binding: FragmentJoinScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJoinScreenBinding.inflate(inflater)
        return binding.root
    }
}