package eu.maksimov.advent.year2018.day1

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val input = readResourceLines("day1_input").map { it.toInt() }

    val result1 = FrequencyResolver(input).resolve()
    println("Correct frequency: $result1")

    val result2 = FrequencyResolver(input).resolveRepeating()
    println("Correct repeating frequency: $result2")
}