//
//  TrafficTypeConverters.kt
//  TrafficCounter
//  Erstellt von Bengin Sternas am 08.06.2025
//  Letzte update 08.06.2025
//

package de.thkoeln.vma.trafficcounter.model.data.database

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Converters {
    private val formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    @TypeConverter
    fun fromLocalDateTime(dateTime: LocalDateTime?): String? {
        return dateTime?.format(formatter)
    }

    @TypeConverter
    fun toLocalDateTime(dateTime: String?): LocalDateTime? {
        return dateTime?.let { LocalDateTime.parse(it, formatter) }
    }
}
