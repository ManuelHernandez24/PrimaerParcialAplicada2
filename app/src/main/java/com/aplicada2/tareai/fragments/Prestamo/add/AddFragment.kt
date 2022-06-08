package com.aplicada2.tareai.fragments.Prestamo.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.aplicada2.tareai.R
import com.aplicada2.tareai.data.database.entities.Prestamo
import com.aplicada2.tareai.iu.viewmodel.PrestamoViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {


    private lateinit var mPrestamoViewModel: PrestamoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mPrestamoViewModel = ViewModelProvider(this).get(PrestamoViewModel::class.java)

        view.add_btn.setOnClickListener{
            insertDataToDatabase()
        }

        return  view
    }

    private fun insertDataToDatabase() {

        if(
            addDeudor_et.text.toString().length > 2 && // Que el nombre sea mayor que 3 caracteres
            addConcepto_et.text.toString().length > 0 && // Que el conecpto no quede vacio
            addMonto_et.text.toString().length > 0 // Que el monto no quede vacio
        ){
            if((addMonto_et.text.toString()).toDouble() >= 0){

                val deudor = addDeudor_et.text.toString()
                val concepto = addConcepto_et.text.toString()
                val monto = (addMonto_et.text.toString()).toDouble()

                //Se crea el prestamo
                val prestamo = Prestamo(0, deudor, concepto, (monto.toString()).toDouble())

                //Se manda a la baase de datos
                mPrestamoViewModel.addPrestamo((prestamo))
                Toast.makeText(requireContext(),getString(R.string.AgregarSinErrores), Toast.LENGTH_LONG).show()

                //Ir atras
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }else {
                Toast.makeText(requireContext(), getString(R.string.ErrorNumerosNegativos), Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(requireContext(),getString(R.string.AgregarConErrores), Toast.LENGTH_LONG).show()
        }
    }
}