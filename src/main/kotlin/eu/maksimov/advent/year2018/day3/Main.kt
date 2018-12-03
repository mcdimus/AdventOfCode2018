package eu.maksimov.advent.year2018.day3

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val fabricModel = FabricModel(1000)
    val claims = readResourceLines("day3_input").map { FabricClaim.of(it) }

    claims.forEach { fabricModel.add(it) }

    // part 1
    println("${fabricModel.countIntersected()} square inches of fabric are within two or more claims")

    // part 2
    val intactClaim = claims.first { fabricModel.isIntact(it) }
    println("The only claim that doesn't overlap $intactClaim")
}