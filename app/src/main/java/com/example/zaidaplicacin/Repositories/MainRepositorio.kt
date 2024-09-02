package com.example.zaidaplicacin.Repositories

import com.example.zaidaplicacin.AppDataBases.AppDataBases
import com.example.zaidaplicacin.Entities.Perro
import com.example.zaidaplicacin.POJOs.DatosPerro
import kotlinx.coroutines.flow.Flow

class MainRepositorio(private var db : AppDataBases) {

    fun selectAllPerros() : Flow<List<Perro>> {

        return db.PerroDAO().selectAllPerros()

    }

    fun selectPerro(id : Int) : Flow<Perro> {

        return db.PerroDAO().selectPerro(id)

    }

    fun selectDatosPerro() : Flow<List<Perro>> {

        return db.PerroDAO().selectAllPerros()

    }

}
