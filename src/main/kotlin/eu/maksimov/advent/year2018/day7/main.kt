package eu.maksimov.advent.year2018.day7

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val pairs = readResourceLines("day7_input").map {
        it.removePrefix("Step ").first().toString() to it.removeSuffix(" can begin.").last().toString()
    }

    val instructions = Instructions()

    for (pair in pairs) {
        instructions.addStep(pair.first, pair.second)
    }

    // part 1
    println("In what order should the steps in your instructions be completed?")
    println(instructions.getStepsOrder())

    // part 2
    println("With 5 workers and the 60+ second step durations described above, how long will it take to complete all of the steps?")
    println(instructions.getDurationWithParallelWorkers(5))

}