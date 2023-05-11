package com.example.doevida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doevida.databinding.ActivityIntroBinding
import java.util.jar.Attributes.Name

class intro : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btStar = binding.btStart
        val nameUser = binding.txtVarName
        val  nameGet = intent.getStringExtra("NameUser")
        nameUser.text = nameGet

        btStar.setOnClickListener {
            val intenDon = Intent(this, Donat::class.java)
            startActivity(intenDon)

        }

        //setContentView(R.layout.activity_intro)
    }



    }
