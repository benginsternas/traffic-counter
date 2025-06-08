//
//  TrafficDao.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 08.06.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.model.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import kotlinx.coroutines.flow.Flow

@Dao
interface TrafficDao {
    @Insert
    suspend fun insertTraffic(traffic: Traffic)

    @Query("SELECT * FROM traffic")
    fun getTotalTraffic(): Flow<List<Traffic>>

    @Query("SELECT * FROM traffic WHERE trafficType = 0")
    fun getCyclingTraffic(): Flow<List<Traffic>>

    @Query("SELECT * FROM traffic WHERE trafficType = 1")
    fun getFootTraffic(): Flow<List<Traffic>>

    @Query("DELETE FROM traffic")
    suspend fun deleteAllTraffic()

    @Query("SELECT * FROM traffic WHERE id = :id")
    fun getTrafficById(id: Int): Flow<Traffic>

    @Query("SELECT COUNT(*) FROM traffic WHERE trafficType = 0")
    fun getCyclingTrafficCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM traffic WHERE trafficType = 1")
    fun getFootTrafficCount(): Flow<Int>

    @Query("SELECT COUNT(*) FROM traffic")
    fun getTotalTrafficCount(): Flow<Int>
}