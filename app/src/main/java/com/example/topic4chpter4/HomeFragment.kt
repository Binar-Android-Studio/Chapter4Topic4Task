package com.example.topic4chpter4

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.topic4chpter4.databinding.FragmentHomeBinding
import com.example.topic4chpter4.databinding.FragmentLoginBinding

class HomeFragment : Fragment() {
    lateinit var binding : FragmentHomeBinding
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sharedPrefs = requireActivity().getSharedPreferences("registerData", Context.MODE_PRIVATE)

        binding.txtname.text = sharedPrefs.getString("fullName", "")

        binding.signout.setOnClickListener {
            var pref = sharedPrefs.edit()
            pref.clear()
            pref.apply()
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}