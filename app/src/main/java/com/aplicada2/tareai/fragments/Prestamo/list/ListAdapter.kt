package com.aplicada2.tareai.fragments.Prestamo.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.aplicada2.tareai.R
import com.aplicada2.tareai.data.database.entities.Prestamo
import kotlinx.android.synthetic.main.custon_row.view.*


class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var prestamoLista = emptyList<Prestamo>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custon_row, parent, false))
    }

    override fun getItemCount(): Int {
        return  prestamoLista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //Para concatenar dos string

        fun concat(s1: String, s2: String): String {
            return s1 + s2
        }

        val currentItem = prestamoLista[position]
        holder.itemView.id_txt.text = currentItem.PrestamoId.toString()
        holder.itemView.deudor_txt.text = currentItem.Deudor
        holder.itemView.concepto_txt.text = currentItem.Concepto
        holder.itemView.monto_txt.text = concat(currentItem.Monto.toString(), "$")

        holder.itemView.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(persona: List<Prestamo>){
        this.prestamoLista = persona
        notifyDataSetChanged()
    }
}