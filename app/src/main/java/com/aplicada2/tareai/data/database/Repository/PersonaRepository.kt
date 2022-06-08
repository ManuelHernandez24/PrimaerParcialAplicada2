package com.aplicada2.tareai.data.database.Repository

import androidx.lifecycle.LiveData
import com.aplicada2.tareai.data.database.dao.PersonaDao
import com.aplicada2.tareai.data.database.entities.Prestamo

class PersonaRepository(private  val personaDao: PersonaDao) {

    val readAllData: LiveData<List<Prestamo>> = personaDao.readAllData()

    suspend fun addPersona(persona: Prestamo){
        personaDao.addPersona(persona)
    }

    suspend fun updatePersona(persona: Prestamo){
        personaDao.updatePersona(persona)
    }

    suspend fun deletePersona(persona: Prestamo){
        personaDao.deletePersona(persona)
    }

    suspend fun deleteAllPersona(){
        personaDao.deleteAllPersona()
    }

}