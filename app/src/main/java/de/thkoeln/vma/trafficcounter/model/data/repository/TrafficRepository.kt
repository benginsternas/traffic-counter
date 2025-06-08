//
//  TrafficRepository.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 08.06.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.model.data.repository

import androidx.annotation.WorkerThread
import de.thkoeln.vma.trafficcounter.model.data.dao.TrafficDao
import de.thkoeln.vma.trafficcounter.model.data.entities.Traffic
import kotlinx.coroutines.flow.Flow

class TrafficRepository(private val trafficDao: TrafficDao) {

    // Flows to observe data from the database
    val totalTraffic: Flow<List<Traffic>> = trafficDao.getTotalTraffic()
    val cyclingTraffic: Flow<List<Traffic>> = trafficDao.getCyclingTraffic()
    val footTraffic: Flow<List<Traffic>> = trafficDao.getFootTraffic()

    // Function to get counts of different traffic types
    fun getCyclingTrafficCount(): Flow<Int> = trafficDao.getCyclingTrafficCount()
    fun getFootTrafficCount(): Flow<Int> = trafficDao.getFootTrafficCount()
    fun getTotalTrafficCount(): Flow<Int> = trafficDao.getTotalTrafficCount()

    // Suspend functions for database operations
    @WorkerThread
    suspend fun insertTraffic(traffic: Traffic) {
        trafficDao.insertTraffic(traffic)
    }

    @WorkerThread
    suspend fun deleteAllTraffic() {
        trafficDao.deleteAllTraffic()
    }
}