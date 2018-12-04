package eu.maksimov.advent.year2018.day4

import java.time.LocalDateTime

sealed class Event {
    data class BeginEvent(val guardId: String, val timestamp: LocalDateTime) : Event()
    data class SleepEvent(val timestamp: LocalDateTime) : Event()
    data class WakeUpEvent(val timestamp: LocalDateTime) : Event()
}