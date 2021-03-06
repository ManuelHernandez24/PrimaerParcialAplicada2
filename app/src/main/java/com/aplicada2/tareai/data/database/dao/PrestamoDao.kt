package com.aplicada2.tareai.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aplicada2.tareai.data.database.entities.Prestamo

@Dao
interface PrestamoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPrestamo(prestamo : Prestamo)

    @Update
    suspend fun updatePrestamo(prestamo: Prestamo)

    @Delete
    suspend fun deletePrestamo(prestamo: Prestamo)

    @Query("DELETE FROM prestamos")
    suspend fun deleteAllPrestamo()

    @Query("SELECT * FROM prestamos ORDER BY PrestamoId ASC")
    fun readAllData(): LiveData<List<Prestamo>>

}