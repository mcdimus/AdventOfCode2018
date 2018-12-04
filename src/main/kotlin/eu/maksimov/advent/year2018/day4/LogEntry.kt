package eu.maksimov.advent.year2018.day4

import eu.maksimov.advent.year2018.day4.Event.*
import eu.maksimov.advent.year2018.shared.roundToDay
import java.time.LocalDate

class LogEntry {

    companion object {
        private const val ASLEEP = true
        private const val AWAKE = false
    }

    lateinit var id: String
    lateinit var date: LocalDate
    val minutes = Array(60) { AWAKE }

    fun addEvent(event: Event) {
        when (event) {
            is SleepEvent -> minutes.fill(ASLEEP, event.timestamp.minute)
            is WakeUpEvent -> minutes.fill(AWAKE, event.timestamp.minute)
            is BeginEvent -> {
                id = event.guardId
                date = event.timestamp.roundToDay()
            }
        }
    }

    override fun toString(): String {
        return "$date  #$id  ${minutes.joinToString(separator = "") { if (it) "#" else "." }}"
    }

}
