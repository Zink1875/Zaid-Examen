package com.example.zaidaplicacin.DAOs

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.zaidaplicacin.Entities.Perro
import com.example.zaidaplicacin.POJOs.DatosPerrito
import kotlinx.coroutines.flow.Flow

@Dao
interface PerroDAO {

    @Insert
    fun insertPerro(nombre: Perro)

    @Update
    fun updatePerro(nombre: Perro)

    @Delete
    fun deletePerro(nombre: Perro)

    @Query(" SELECT * FROM Perro ")
    fun selectAllPerro(): Flow<List<Perro>>

    @Query(" SELECT * FROM perro WHERE id = :id ")
    fun selectPerro(id: Int): Flow<Perro>

}


