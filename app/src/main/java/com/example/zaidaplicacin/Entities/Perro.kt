package com.example.zaidaplicacin.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Perro (

    @PrimaryKey
    var id : Int?,

    @ColumnInfo(name = "nombre")
    var nombre : String,

    @ColumnInfo(name = "raza")
    var raza : String,

    @ColumnInfo(name = "edad")
    var edad : String,

    @ColumnInfo(name = "sexo")
    var sexo : String

)