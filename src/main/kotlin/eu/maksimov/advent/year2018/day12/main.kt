package eu.maksimov.advent.year2018.day12

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val inputLines = readResourceLines("day12_input")
    val garden = Garden(
        initialState = inputLines.first().substringAfter("initial state: "),
        rules = inputLines.drop(2).map { Rule(it) }
    )

    var prevSum = 0;
    for (i in 1..130) {
        garden.evolve()

        // made an observation that after 130th generation each further generation adds 52 to a result
        val curSum = garden.sumOfPotNumberContainingPlant()
        println(i.toString() + ": " + (curSum - prevSum))
        prevSum = curSum
    }

    val base = garden.sumOfPotNumberContainingPlant()
    println(base + (50_000_000_000 - 130) * 52)
}