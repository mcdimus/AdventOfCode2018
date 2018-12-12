package eu.maksimov.advent.year2018.day10

data class Point(
    private var x: Int,
    private var y: Int,
    private val velocityX: Int,
    private val velocityY: Int
) {

    fun getX() = x
    fun getY() = y

    fun applyVelocity() {
        x += velocityX
        y += velocityY
    }

    companion object {
        fun parse(value: String): Point {
            val beginA = value.indexOf('<')
            val endA = value.indexOf('>')

            val beginB = value.lastIndexOf('<')
            val endB = value.lastIndexOf('>')

            val coordinates = value.substring(beginA + 1, endA).split(",").map { it.trim().toInt() }
            val velocity = value.substring(beginB + 1, endB).split(",").map { it.trim().toInt() }

            return Point(coordinates[0], coordinates[1], velocity[0], velocity[1])
        }
    }
}