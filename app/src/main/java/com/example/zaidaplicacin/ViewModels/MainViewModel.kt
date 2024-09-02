package com.example.zaidaplicacin.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.zaidaplicacin.Entities.Perro
import com.example.zaidaplicacin.POJOs.DatosPerro
import com.example.zaidaplicacin.Repositories.MainRepositorio
import kotlinx.coroutines.Dispatchers
import java.util.concurrent.Flow

class MainViewModel(private val repo : MainRepositorio) : ViewModel() {

    var datoAPasar = ""

    fun selectAllPerros() : LiveData<List<Perro>> {

        return repo.selectAllPerros().asLiveData(Dispatchers.IO)

    }

    fun selectPerro(id : Int) : LiveData<Perro> {

        return repo.selectPerro(id).asLiveData(Dispatchers.IO)

    }

    fun selectDatosPerro() : LiveData<List<Perro>> {

        return repo.selectAllPerros().asLiveData(Dispatchers.IO)

    }

}