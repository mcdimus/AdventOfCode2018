package eu.maksimov.advent.year2018.shared

fun readResourceLines(filename: String) =
    ClassLoader.getSystemResource(filename).readText().split("\n")