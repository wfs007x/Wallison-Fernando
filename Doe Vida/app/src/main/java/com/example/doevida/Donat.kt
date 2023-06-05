package com.example.doevida

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.doevida.databinding.ActivityDonatBinding
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference



class Donat : AppCompatActivity() {

    private lateinit var binding: ActivityDonatBinding
    private lateinit var dbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDonatBinding.inflate(layoutInflater)

        //Código para remover a ActionBar
        supportActionBar?.hide()

        setContentView(binding.root)

        var cadDonName = binding.txtNameDonat
        var cadDonMail = binding.txtEmailDonat
        var cadDonPhone = binding.txtPhoneDonat
        var cadDonValue = binding.txtValueMoney
        var cadDonInst = binding.txtInstDonat
        var btDon = binding.btDonate

        dbRef = FirebaseDatabase.getInstance().getReference("Doador")

        btDon.setOnClickListener {

            val cadDonNamebt = cadDonName.text.toString()
            val cadDonMailbt = cadDonMail.text.toString()
            val cadDonPhonebt = cadDonPhone.text.toString()
            val cadDonValuebt = cadDonValue.text.toString()
            val cadDonInstbt = cadDonInst.text.toString()

            if (cadDonNamebt.isEmpty()) {
                cadDonName.error = resources.getString(R.string.hintname)
            }
            if (cadDonMailbt.isEmpty()) {
                cadDonMail.error = resources.getString(R.string.hintmail)
            }
            if (cadDonPhonebt.isEmpty()) {
                cadDonPhone.error = resources.getString(R.string.hintphone)
            }

            if (cadDonValuebt.isEmpty()) {
                cadDonValue.error = resources.getString(R.string.hintvalue)
            }

            if (cadDonInstbt.isEmpty()) {
                cadDonInst.error = resources.getString(R.string.hintinst)
            }

            if (cadDonNamebt != "" && cadDonMailbt != "" && cadDonPhonebt != "" &&
                cadDonValuebt != "" &&
                cadDonInstbt != ""
            ) {

                val empId = dbRef.push().key!!

                val Doador = ModelDonate(
                    cadDonNamebt, cadDonMailbt, cadDonPhonebt, cadDonValuebt, cadDonInstbt
                )

                dbRef.child(empId).setValue(Doador)
                    .addOnCompleteListener {
                        Toast.makeText(this, "Cadastro realizado", Toast.LENGTH_SHORT).show()

                        cadDonName.text.clear()
                        cadDonMail.text.clear()
                        cadDonPhone.text.clear()
                        cadDonValue.text.clear()
                        cadDonInst.text.clear()

                    }.addOnFailureListener { err ->
                        Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_SHORT).show()
                    }
                // setContentView(R.layout.activity_donat)
            } else {
                Toast.makeText(this, R.string.ErrorCad, Toast.LENGTH_SHORT).show()
            }
        }
    }
}