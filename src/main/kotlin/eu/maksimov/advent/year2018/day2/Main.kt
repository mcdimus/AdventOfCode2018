package eu.maksimov.advent.year2018.day2

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    var twos = 0
    var threes = 0
    val boxes = readResourceLines("day2_input").map { Box(it) }

    // part 1
    boxes.forEach {
        if (it.countsForTwo)
            twos++
        if (it.countsForThree)
            threes++
    }
    println("Checksum: ${twos * threes}")

    // part 2
    val commonLetters = CorrectBoxesFinder(boxes).getCommonLetters()
    println("Common letters: $commonLetters")
}