package com.example.zaidaplicacin.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.zaidaplicacin.AppDataBases.AppDataBases
import com.example.zaidaplicacin.Repositories.MainRepositorio
import com.example.zaidaplicacin.ViewModels.MainViewModel
import com.example.zaidaplicacin.ViewModels.ViewModelFactory
import com.example.zaidaplicacin.databinding.ActivityLoginBinding
import com.example.zaidaplicacin.databinding.FragmentBinding
import com.google.android.material.snackbar.Snackbar

class Fragment : DialogFragment() {

    private var _binding : FragmentBinding? = null

    private val binding get() = _binding!!



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel : MainViewModel by activityViewModels {
            ViewModelFactory(MainRepositorio(AppDataBases.getDatabase(requireContext())))
        }

        binding.textViewDato.text = viewModel.datoAPasar

        binding.botonSalir.setOnClickListener {

            this.dismiss()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    companion object {

        @JvmStatic
        fun newInstance() = Fragment()
    }
}

