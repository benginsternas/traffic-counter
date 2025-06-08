//
//  Traffic.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.model.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "Traffic")
data class Traffic(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
) {
    enum class TrafficType {
        CYCLING, FOOT
    }

    fun getTrafficTypeDisplayName(): String {
        return when (trafficType) {
            TrafficType.CYCLING -> "Radfahrer:in"
            TrafficType.FOOT -> "Fußgänger:in"
        }
    }
}