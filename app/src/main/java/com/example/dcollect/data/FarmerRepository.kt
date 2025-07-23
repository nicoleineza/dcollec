package com.example.dcollect.data

import kotlinx.coroutines.flow.Flow

class FarmerRepository(private val farmerDao: FarmerDao) {
    val allFarmers: Flow<List<Farmer>> = farmerDao.getAllFarmers()

    suspend fun insert(farmer: Farmer) {
        farmerDao.insertFarmer(farmer)
    }

    suspend fun getUnsyncedFarmers(): List<Farmer> {
        return farmerDao.getUnsyncedFarmers()
    }

    suspend fun markAsSynced(farmer: Farmer) {
        val updatedFarmer = farmer.copy(isSynced = true)
        farmerDao.updateFarmer(updatedFarmer)
    }
}