package com.aplicada2.tareai.data.database.Repository

import androidx.lifecycle.LiveData
import com.aplicada2.tareai.data.database.dao.PersonaDao
import com.aplicada2.tareai.data.database.entities.Cosa

class PersonaRepository(private  val personaDao: PersonaDao) {

    val readAllData: LiveData<List<Cosa>> = personaDao.readAllData()

    suspend fun addPersona(persona: Cosa){
        personaDao.addPersona(persona)
    }

    suspend fun updatePersona(persona: Cosa){
        personaDao.updatePersona(persona)
    }

    suspend fun deletePersona(persona: Cosa){
        personaDao.deletePersona(persona)
    }

    suspend fun deleteAllPersona(){
        personaDao.deleteAllPersona()
    }

}