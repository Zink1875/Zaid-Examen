package com.example.zaidaplicacin.Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.zaidaplicacin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val nombre : String? = intent.getStringExtra("nombre")
        val raza : String? = intent.getStringExtra("raza")
        val edad : String? = intent.getStringExtra("edad")
        val sexo : String? = intent.getStringExtra("sexo")

        when {

            ( nombre == null || raza == null || edad == null || sexo == null ) ->{

                binding.textViewSaludo.text = "No hubo información del perro"

            }

            else -> {

                binding.textViewSaludo.text = "Bien" + nombre.toString() + ", raza" + raza.toString() + ", edad" + edad.toString() + ",sexo" + sexo.toString()

            }
        }

    }

}