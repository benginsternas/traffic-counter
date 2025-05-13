package de.thkoeln.vma.trafficcounter

import java.time.LocalDateTime

data class Traffic(
    val trafficType: TrafficType,
    val date: LocalDateTime,
    val note: String
) {
    enum class TrafficType {
        CYCLING, FOOT
    }

    fun getTrafficTypeDisplayName(): String {
        return when (trafficType) {
            TrafficType.CYCLING -> "Fahrradfahrer:in"
            TrafficType.FOOT -> "Fußgänger:in"
        }
    }
}
