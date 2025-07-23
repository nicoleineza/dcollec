package com.example.dcollect.data
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farmers")
data class Farmer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val idNumber: String,
    val cropType: String,
    val registrationDate: Long = System.currentTimeMillis(),
    val isSynced: Boolean = false
)
