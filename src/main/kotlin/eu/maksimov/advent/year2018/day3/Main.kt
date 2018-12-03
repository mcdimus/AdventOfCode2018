package eu.maksimov.advent.year2018.day3

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val fabricModel = FabricModel(1000)
    readResourceLines("day3_input").map { FabricClaim.of(it) }
        .forEach { fabricModel.add(it) }

    println("${fabricModel.countIntersected()} square inches of fabric are within two or more claims")
}