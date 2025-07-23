package com.example.dcollect.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FarmerDao {
    @Insert
    suspend fun insertFarmer(farmer: Farmer): Long

    @Query("SELECT * FROM farmers ORDER BY registrationDate DESC")
    fun getAllFarmers(): Flow<List<Farmer>>

    @Query("SELECT * FROM farmers WHERE isSynced = 0")
    suspend fun getUnsyncedFarmers(): List<Farmer>

    @Update
    suspend fun updateFarmer(farmer: Farmer)
}