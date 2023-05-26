package com.example.doevida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.doevida.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val vUser = binding.txtName
        val vPass = binding.txtpass
        val vlogin = binding.btLogin

        vlogin.setOnClickListener {
            if(vUser.text.toString() == "Wallison" && vPass.text.toString() == "Focus") {
                val inten = Intent(this, intro::class.java)
                val valtxtname = vUser.text.toString()
                inten.putExtra("NameValue", valtxtname)

                startActivity(inten)
            }
            else{
                Toast.makeText(this, R.string.msgError, Toast.LENGTH_SHORT).show()
                //vlogin.text = vUser.text.toString()

            }
        }


        //setContentView(R.layout.activity_main)
    }
}