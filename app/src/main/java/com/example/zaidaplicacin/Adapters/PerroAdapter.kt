package com.example.zaidaplicacin.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.zaidaplicacin.Entities.Perro
import com.example.zaidaplicacin.databinding.ItemPerroBinding
import com.google.android.material.snackbar.Snackbar


class PerroAdapter(private var perro : ArrayList<Perro>) : RecyclerView.Adapter<PerroAdapter.ViewHolderPerro>() {

    inner class ViewHolderPerro(val binding : ItemPerroBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(perro: Perro) {

            binding.apply {

                viewnombreperrito.text = perro.nombre
                textViewRaza.text = perro.raza
                textViewEdad.text = perro.edad
                textViewSexo.text = perro. sexo


                BotonAlerta.setOnClickListener {

                    Snackbar.make(binding.root, perro.nombre, 1000).show()

                }

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPerro {

        val binding = ItemPerroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderPerro(binding)

    }

    override fun onBindViewHolder(holder: ViewHolderPerro, position: Int) {

        holder.bind(perro[position])

    }

    override fun getItemCount(): Int {

        return perro.size

    }

    fun updatePerros(nuevosPerros: ArrayList<Perro>) {

        perro = nuevosPerros
        this.notifyDataSetChanged()

    }

}