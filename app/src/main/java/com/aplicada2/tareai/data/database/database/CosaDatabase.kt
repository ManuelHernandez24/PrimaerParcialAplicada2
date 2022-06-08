package com.aplicada2.tareai.data.database.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class CosaDatabase: RoomDatabase() {


    companion object{
        @Volatile
        private var INSTANCE: CosaDatabase? = null

        fun getDatabase(context: Context): CosaDatabase {
            val tempInstance = INSTANCE

            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CosaDatabase::class.java,
                    "tabla_Cosa"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}