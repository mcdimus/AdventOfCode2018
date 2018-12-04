package eu.maksimov.advent.year2018.shared

import java.time.LocalDate
import java.time.LocalDateTime

fun LocalDateTime.roundToDay(): LocalDate {
    return if (this.hour < 12) {
        LocalDate.from(this)
    } else {
        LocalDate.from(this.plusDays(1))
    }
}