package eu.maksimov.advent.year2018.day6

data class Point(val x: Int, val y: Int) {

    var closestBasePoint: Point? = null

    fun manhattanDistanceTo(other: Point) = Math.abs(this.x - other.x) + Math.abs(this.y - other.y)

}