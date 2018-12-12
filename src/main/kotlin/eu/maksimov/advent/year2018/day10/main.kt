package eu.maksimov.advent.year2018.day10

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val points = readResourceLines("day10_input").map { Point.parse(it) }

    Sky(points).printText()
}