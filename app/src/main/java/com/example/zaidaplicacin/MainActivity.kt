package com.example.zaidaplicacin

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.zaidaplicacin.Adapters.PerroAdapter
import com.example.zaidaplicacin.AppDataBases.AppDataBases
import com.example.zaidaplicacin.Fragment.Fragment
import com.example.zaidaplicacin.Repositories.MainRepositorio
import com.example.zaidaplicacin.ViewModels.MainViewModel
import com.example.zaidaplicacin.ViewModels.ViewModelFactory
import com.example.zaidaplicacin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val adapter = PerroAdapter(ArrayList())

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        val viewModel: MainViewModel by viewModels {
            ViewModelFactory(MainRepositorio(AppDataBases.getDatabase(this)))
        }

        binding.botonfragment.setOnClickListener {

            viewModel.datoAPasar = "Hola, este dato viene del activity"

            Fragment().show(supportFragmentManager, "Fragment")

        }

        viewModel.selectDatosPerro().observe(this, Observer { listaPerro ->

            adapter.updatePerros(ArrayList(listaPerro))

        })

    }
}

