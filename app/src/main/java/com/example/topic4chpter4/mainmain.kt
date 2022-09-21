package com.example.topic4chpter4

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.topic4chpter4.databinding.ActivityMainmainBinding

class mainmain : AppCompatActivity() {
    lateinit var binding : ActivityMainmainBinding
    lateinit var  sharedPrefs : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainmainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("Student", Context.MODE_PRIVATE)

        binding.save.setOnClickListener{
            saveData()
            Toast.makeText( this,"Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
        }

        binding.view.setOnClickListener{
            viewData()
        }

        binding.clear.setOnClickListener{
            clearData()
        }

    }
    fun saveData(){
        var getNim = binding.nim.text.toString()
        var getName = binding.name.text.toString()

        var addData = sharedPrefs.edit()
        addData.putString("nim", getNim)
        addData.putString("name", getName)
        addData.apply()
    }

    fun viewData(){
        binding.txtnim.text = "NIM :" + sharedPrefs.getString("nim2", "")
        binding.txtName.text = "Name :" +sharedPrefs.getString("name", "")
    }

    fun clearData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()

        binding.txtName.setText("")
        binding.txtnim.setText("")
    }
}