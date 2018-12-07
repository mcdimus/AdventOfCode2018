import eu.maksimov.advent.year2018.day6.Grid
import eu.maksimov.advent.year2018.day6.Point
import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val basePoints = readResourceLines("day6_input").map {
        Point(
            it.substringBefore(',').toInt(),
            it.substringAfter(", ").toInt()
        )
    }

    val grid = Grid(basePoints)

    // part 1
    println("What is the size of the largest area that isn't infinite?")
    println(grid.getSizeOfLargestFiniteArea())
}