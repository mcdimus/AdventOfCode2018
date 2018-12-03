package eu.maksimov.advent.year2018.day2

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val boxes = readResourceLines("day2_input").map { Box(it) }

    // part 1
    println("Checksum: ${boxes.getChecksum()}")

    // part 2
    val commonLetters = CorrectBoxesFinder(boxes).getCommonLetters()
    println("Common letters: $commonLetters")
}

private fun List<Box>.getChecksum(): Int {
    var twos = 0
    var threes = 0
    this.forEach {
        if (it.countsForTwo) twos++
        if (it.countsForThree) threes++
    }
    return twos * threes
}
