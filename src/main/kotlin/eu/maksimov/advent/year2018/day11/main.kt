package eu.maksimov.advent.year2018.day11

fun main() {
    val grid = Grid(8979)

    // part 1
    println("What is the X,Y coordinate of the top-left fuel cell of the 3x3 square with the largest total power?")
    println(grid.getMostPowerfulSquareCoords())
}