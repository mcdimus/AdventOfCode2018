package eu.maksimov.advent.year2018.day4

import eu.maksimov.advent.year2018.day4.Event.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LogProcessor {

    fun process(rawLogEntries: List<String>): List<LogEntry> {
        val logEntries = ArrayList<LogEntry>()
        var currentLogEntry: LogEntry? = null
        for (rawEntry in rawLogEntries.sorted()) {
            when {
                rawEntry.endsWith("begins shift") -> {
                    currentLogEntry?.also { logEntries.add(it) }
                    currentLogEntry = LogEntry().apply {
                        addEvent(BeginEvent(rawEntry.getGuardId(), rawEntry.getTimestamp()))
                    }
                }
                rawEntry.endsWith("falls asleep") -> currentLogEntry?.addEvent(SleepEvent(rawEntry.getTimestamp()))
                rawEntry.endsWith("wakes up") -> currentLogEntry?.addEvent(WakeUpEvent(rawEntry.getTimestamp()))
            }
        }
        logEntries.add(currentLogEntry!!)
        return logEntries
    }

    fun findMediocreGuardAndMinuteCombination(entries: List<LogEntry>): Pair<Int, Int> {
        return findGuardAndMinuteCombination(entries) { it.sum() }
    }

    fun findBestGuardAndMinuteCombination(entries: List<LogEntry>): Pair<Int, Int> {
        return findGuardAndMinuteCombination(entries) { it.max() ?: 0 }
    }

    private fun findGuardAndMinuteCombination(entries: List<LogEntry>, strategy: (Array<Int>) -> Int): Pair<Int, Int> {
        val sleepyMinutesCountsPerGuard = entries.groupBy { it.id }
            .map { (guardId, entries) ->
                val minuteCounts = Array(60) { 0 }
                entries.map { it.minutes }.forEach {
                    it.forEachIndexed { index, isAsleep -> if (isAsleep) minuteCounts[index]++ }
                }
                Pair(guardId, minuteCounts)
            }.toMap()

        val bestGuardAndMinutes = sleepyMinutesCountsPerGuard.maxBy { strategy.invoke(it.value) }!!
        return Pair(
            bestGuardAndMinutes.key.toInt(),
            bestGuardAndMinutes.value.indices.maxBy { bestGuardAndMinutes.value[it] } ?: 0
        )
    }

    private fun String.getGuardId(): String {
        return this.substringAfter('#').takeWhile { it != ' ' }
    }

    private fun String.getTimestamp(): LocalDateTime {
        return LocalDateTime.parse(
            this.substring(this.indexOf("[") + 1, this.indexOf("]")).replace(' ', 'T'),
            DateTimeFormatter.ISO_LOCAL_DATE_TIME
        )
    }

}
