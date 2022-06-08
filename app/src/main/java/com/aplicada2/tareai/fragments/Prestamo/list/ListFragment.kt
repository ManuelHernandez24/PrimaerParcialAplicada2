package com.aplicada2.tareai.fragments.Prestamo.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aplicada2.tareai.R
import com.aplicada2.tareai.iu.viewmodel.PrestamoViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragment : Fragment() {


    private lateinit var mPrestamoView: PrestamoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        //recyclerView
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //PersonaViewModel
        mPrestamoView = ViewModelProvider(this).get(PrestamoViewModel::class.java)
        mPrestamoView.readAllData.observe(viewLifecycleOwner, Observer { persona ->
            adapter.setData(persona)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

        //Menu para eliminar todas las personas registradas
        setHasOptionsMenu(true)

        return view
    }
}