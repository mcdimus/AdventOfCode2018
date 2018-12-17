package eu.maksimov.advent.year2018.shared

enum class Direction(val dx: Int = 0, val dy: Int = 0) {

    UP(dy = -1),
    DOWN(dy = 1),
    LEFT(dx = -1),
    RIGHT(dx = 1);

    fun apply(point: Point) = Point(dx + point.x, dy + point.y)

}