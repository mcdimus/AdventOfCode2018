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

    val grid = Grid(basePoints, 10_000)

    // part 1
    println("What is the size of the largest area that isn't infinite?")
    println(grid.getSizeOfLargestFiniteArea())

    // part 2
    println(
        "What is the size of the region containing all locations which have a total distance to all given  " +
                "coordinates of less than 10000?"
    )
    println(grid.getSafeRegionSize())
}