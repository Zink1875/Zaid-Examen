package com.example.zaidaplicacin.AppDataBases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.zaidaplicacin.DAOs.PerroDAO
import com.example.zaidaplicacin.Entities.Perro

@Database(entities = [Perro::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun PerroDAO() : PerroDAO

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {

            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).build()

                INSTANCE = instance
                instance

            }

        }

    }

}