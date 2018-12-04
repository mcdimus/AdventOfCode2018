package eu.maksimov.advent.year2018.day4

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val logEntries = readResourceLines("day4_input")
    val logProcessor = LogProcessor()
    val processedEntries = logProcessor.process(logEntries)

    // part 1
    val mediocreCombination = logProcessor.findMediocreGuardAndMinuteCombination(processedEntries)
    println("Strategy 1: ${mediocreCombination.let { it.first * it.second }}")

    // part 2
    val bestCombination = logProcessor.findBestGuardAndMinuteCombination(processedEntries)
    println("Strategy 2: ${bestCombination.let { it.first * it.second }}")

}