//
//  TrafficApplication.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 08.06.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter

import android.app.Application
import de.thkoeln.vma.trafficcounter.model.data.database.TrafficDatabase
import de.thkoeln.vma.trafficcounter.model.data.repository.TrafficRepository

class TrafficApplication : Application() {

    private val database by lazy { TrafficDatabase.getDatabase(this) }
    val repository: TrafficRepository by lazy { TrafficRepository(database.trafficDao()) }
}
