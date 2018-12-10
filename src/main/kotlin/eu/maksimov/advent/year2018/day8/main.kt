package eu.maksimov.advent.year2018.day8

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val input = readResourceLines("day8_input").flatMap { it.split(" ") }.map { it.toInt() }

    val rootNode = Node(input)

    // part 1
    println("What is the sum of all metadata entries?")
    println(rootNode.checksum())

    // part 2
    println("What is the value of the root node?")
    println(rootNode.value())
}