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
        val btViewD = binding.btViewDonates
        val nameUser = binding.txtVarName
        val welcomeString = resources.getString(R.string.welcome)
        val  nameGet = intent.getStringExtra("NameValue")

        nameUser.text = welcomeString + " " + nameGet + "!"

        //nameUser.text = R.string.well.toString() + " " + nameGet

        btStar.setOnClickListener {
            val intenDon = Intent(this, Donat::class.java)
            startActivity(intenDon)

        }
        btViewD?.setOnClickListener {
            val intenViewDon = Intent(this, List_Donates::class.java)
            startActivity(intenViewDon)

        }

        //setContentView(R.layout.activity_intro)
    }
    }
