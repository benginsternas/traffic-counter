//
//  Traffic.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 16.04.2025
//

package de.thkoeln.vma.trafficcounter

import java.time.LocalDateTime

// Datenklasse für die erfassten Daten
data class Traffic(
    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
) {
    // Enum für die Verkehrsarten
    enum class TrafficType {
        CYCLING, FOOT
    }

    // Methode zur Umwandlung des TrafficType in einen lesbaren String
    fun getTrafficTypeDisplayName(): String {
        return when (trafficType) {
            TrafficType.CYCLING -> "Radfahrer:in"
            TrafficType.FOOT -> "Fußgänger:in"
        }
    }
}