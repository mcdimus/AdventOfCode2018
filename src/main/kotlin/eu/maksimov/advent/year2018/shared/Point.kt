package eu.maksimov.advent.year2018.shared

data class Point(val x: Int, val y: Int) : Comparable<Point> {

    fun apply(direction: Direction) = Point(x + direction.dx, y + direction.dy)

    override fun compareTo(other: Point) =
        if (this.y == other.y) {
            this.x - other.x
        } else {
            this.y - other.y
        }

}