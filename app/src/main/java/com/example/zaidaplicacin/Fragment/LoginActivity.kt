package com.example.zaidaplicacin.Fragment

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.zaidaplicacin.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity () {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {

            var nombre : String? = binding.editnombreperrito.text.toString()
            var raza : String? = binding. editTextRaza.text.toString()
            var edad : String? = binding.editEdad.text.toString()
            var sexo : String? = binding.editSexo.text.toString()

            if (nombre == "" || raza == "" || edad == "" || sexo == "" ) {

                Snackbar.make(binding.root,  "Por favor, introduzca un usuario y una contraseña", 1000).show()

            }

            else {

                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alerta")
                builder.setMessage("Esto es un fragment de alerta")
                builder.setPositiveButton("OK") {dialog, which ->

                }
                builder.setNegativeButton("cancelar") {dialog, which ->
                }

                builder.create()
                builder.show()

            }

        }

    }

}