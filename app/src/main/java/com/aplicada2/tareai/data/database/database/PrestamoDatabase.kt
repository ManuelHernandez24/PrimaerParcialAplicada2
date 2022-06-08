package com.aplicada2.tareai.data.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aplicada2.tareai.data.database.dao.PrestamoDao
import com.aplicada2.tareai.data.database.entities.Prestamo


@Database(entities = [Prestamo::class], version = 1, exportSchema = false)
abstract class PrestamoDatabase: RoomDatabase() {

    abstract fun prestamoDao(): PrestamoDao

    companion object{
        @Volatile
        private var INSTANCE: PrestamoDatabase? = null

        fun getDatabase(context: Context): PrestamoDatabase {
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PrestamoDatabase::class.java,
                    "prestamos"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}