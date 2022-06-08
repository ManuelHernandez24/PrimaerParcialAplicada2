package com.aplicada2.tareai.iu.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aplicada2.tareai.data.database.Repository.PersonaRepository
import com.aplicada2.tareai.data.database.database.PrestamoDatabase
import com.aplicada2.tareai.data.database.entities.Prestamo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PrestamoViewModel(application : Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Prestamo>>
    private val repository: PersonaRepository

    init{
        val prestamoDao = CosaDatabase.getDatabase(application).prestamoDao()
        repository = PersonaRepository(prestamoDao)
        readAllData = repository.readAllData
    }

    fun addPrestamo(prestamo: Prestamo){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPrestamo(prestamo)
        }
    }

    fun updatePrestamo(prestamo: Prestamo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePrestamo(prestamo)
        }
    }

    fun deletePrestamo(prestamo: Prestamo){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePrestamo(prestamo)
        }
    }

    fun deleteAllPrestamo(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPrestamo()
        }
    }
}