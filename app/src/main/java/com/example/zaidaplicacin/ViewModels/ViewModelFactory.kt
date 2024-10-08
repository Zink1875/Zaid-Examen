package com.example.zaidaplicacin.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.zaidaplicacin.Repositories.MainRepositorio

class ViewModelFactory(private val repo : MainRepositorio) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {

            return MainViewModel(repo) as T

        }

        throw IllegalArgumentException("Clase de ViewModel desconocida")

    }

}