package com.example.dcollect.domain

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.dcollect.data.Farmer
import com.example.dcollect.data.FarmerDatabase
import com.example.dcollect.data.FarmerRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class FarmerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: FarmerRepository
    val allFarmers: LiveData<List<Farmer>>

    init {
        val farmerDao = FarmerDatabase.getDatabase(application).farmerDao()
        repository = FarmerRepository(farmerDao)
        allFarmers = repository.allFarmers.asLiveData()
    }

    open fun insert(farmer: Farmer): Job = viewModelScope.launch {
        repository.insert(farmer)
    }
}
