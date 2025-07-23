package com.example.dcollect.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Farmer::class], version = 1)
abstract class FarmerDatabase : RoomDatabase() {
    abstract fun farmerDao(): FarmerDao

    companion object {
        @Volatile
        private var INSTANCE: FarmerDatabase? = null

        fun getDatabase(context: Context): FarmerDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FarmerDatabase::class.java,
                    "farmer_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}