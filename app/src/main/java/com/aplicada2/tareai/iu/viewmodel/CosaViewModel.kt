package com.aplicada2.tareai.iu.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aplicada2.tareai.data.database.Repository.PersonaRepository
import com.aplicada2.tareai.data.database.database.CosaDatabase
import com.aplicada2.tareai.data.database.entities.Cosa
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CosaViewModel(application : Application): AndroidViewModel(application) {
    val readAllData: LiveData<List<Cosa>>
    private val repository: PersonaRepository

    init{
        val personaDao = CosaDatabase.getDatabase(application).personaDao()
        repository = PersonaRepository(personaDao)
        readAllData = repository.readAllData
    }

    fun addPersona(persona: Cosa){
        viewModelScope.launch (Dispatchers.IO){
            repository.addPersona(persona)
        }
    }

    fun updatePersona(persona: Cosa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePersona(persona)
        }
    }

    fun deletePersona(persona: Cosa){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePersona(persona)
        }
    }

    fun deleteAllPersona(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPersona()
        }
    }
}