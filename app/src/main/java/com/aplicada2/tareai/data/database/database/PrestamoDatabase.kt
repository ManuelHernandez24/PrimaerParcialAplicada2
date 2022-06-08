package com.aplicada2.tareai.data.database.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class PrestamoDatabase: RoomDatabase() {


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
                    "tabla_Prestamo"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}