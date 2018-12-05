package eu.maksimov.advent.year2018.day5

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val input = readResourceLines("day5_input").first()

    val polymer = Polymer(input)

    // part 1
    println("How many units remain after fully reacting the polymer you scanned?")
    println(polymer.simplify().getValue().length)

    // part 2
    println(
        "What is the length of the shortest polymer you can produce by removing all units of exactly one type " +
                "and fully reacting the result?"
    )
    println(polymer.enhance().getValue().length)
}