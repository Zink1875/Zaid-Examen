package com.example.zaidaplicacin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = UsuariosAdapter(ArrayList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        val viewModel : MainViewModel by viewModels {
            ViewModelFactory(MainRepository(AppDatabase.getDatabase(this)))
        }

        binding.botonAbrirFragment.setOnClickListener {

            viewModel.datoAPasar = "Hola, este dato viene del activity"

            EjemploFragment().show(supportFragmentManager, "ejemploFragment")

        }

        viewModel.selectUsuarioConPersona().observe(this, Observer { listaUsuarios ->

            adapter.updateUsuarios(ArrayList(listaUsuarios))

        })

    }
}