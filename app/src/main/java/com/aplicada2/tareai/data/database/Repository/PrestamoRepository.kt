package com.aplicada2.tareai.data.database.Repository

import androidx.lifecycle.LiveData
import com.aplicada2.tareai.data.database.dao.PrestamoDao
import com.aplicada2.tareai.data.database.entities.Prestamo

class PrestamoRepository(private val prestamoDao: PrestamoDao) {

    val readAllData: LiveData<List<Prestamo>> = prestamoDao.readAllData()

    suspend fun addPrestamo(prestamo: Prestamo){
        prestamoDao.addPrestamo(prestamo)
    }

    suspend fun updatePrestamo(prestamo: Prestamo){
        prestamoDao.updatePrestamo(prestamo)
    }

    suspend fun deletePrestamo(prestamo: Prestamo){
        prestamoDao.deletePrestamo(prestamo)
    }

    suspend fun deleteAllPrestamo(){
        prestamoDao.deleteAllPrestamo()
    }

}