package com.aplicada2.tareai.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.aplicada2.tareai.data.database.entities.Cosa

@Dao
interface CosaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPersona(persona : Cosa)

    @Update
    suspend fun updatePersona(persona: Cosa)

    @Delete
    suspend fun deletePersona(persona: Cosa)

    @Query("DELETE FROM tabla_persona")
    suspend fun deleteAllPersona()

    @Query("SELECT * FROM TABLA_PERSONA ORDER BY PersonaId ASC")
    fun readAllData(): LiveData<List<Cosa>>

}