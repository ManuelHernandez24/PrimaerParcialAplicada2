package com.aplicada2.tareai.fragments.Prestamo.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.aplicada2.tareai.R
import com.aplicada2.tareai.data.database.entities.Prestamo
import com.aplicada2.tareai.iu.viewmodel.PrestamoViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


class UpdateFragment : Fragment() {
    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mPrestamoViewModel: PrestamoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mPrestamoViewModel = ViewModelProvider(this).get(PrestamoViewModel::class.java)

        view.updateDeudor_et.setText(args.currentPrestamo.Deudor)
        view.updateConcepto_et.setText(args.currentPrestamo.Concepto)
        view.updateMonto_et.setText(args.currentPrestamo.Monto.toString())

        view.update_btn.setOnClickListener{
            updateItem()
        }
        //Poner el menu de eliminar
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem(){


        if(
            updateDeudor_et.text.toString().length > 2 &&
            updateConcepto_et.text.toString().length > 0 &&
            updateMonto_et.text.toString().length > 0
        ){
            if((addMonto_et.text.toString()).toDouble() >= 0){
                val deudor = addDeudor_et.text.toString()
                val concepto = addConcepto_et.text.toString()
                val monto = (addMonto_et.text.toString()).toDouble()

                //Se crea la persona
                val updatePrestamo = Prestamo(args.currentPrestamo.PrestamoId, deudor, concepto, (monto.toString()).toDouble())
                //Update current persona
                mPrestamoViewModel.updatePrestamo(updatePrestamo)
                Toast.makeText(requireContext(), getString(R.string.ActualizarSinErrores), Toast.LENGTH_SHORT).show()
                //Ir atras
                findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }


        }else{
            Toast.makeText(requireContext(), getString(R.string.ActualizarConErrores), Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(nombres: String, balance: Editable): Boolean{
        return !(TextUtils.isEmpty(nombres) && balance.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deletePrestamo()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deletePrestamo() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton(R.string.Si){_,_ ->
            mPrestamoViewModel.deletePrestamo(args.currentPrestamo)
            Toast.makeText(requireContext(), "${args.currentPrestamo.Deudor} ${R.string.EliminadoConExito}", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton(R.string.No){_,_ ->

        }
        val title : String = ("Eliminar a ${args.currentPrestamo.Deudor}")
        builder.setTitle("${title}")
        builder.setMessage("Estás seguro?")
        builder.create().show()
    }
}