package eu.maksimov.advent.year2018.day6

class Grid(basePoints: List<Point>) {

    val min: Point
    val max: Point
    val grid: MutableList<Point> = arrayListOf()

    init {
        val minX = basePoints.map { it.x }.min()!!
        val minY = basePoints.map { it.y }.min()!!
        val maxX = basePoints.map { it.x }.max()!!
        val maxY = basePoints.map { it.y }.max()!!

        min = Point(minX, minY)
        max = Point(maxX, maxY)

        for (y in minY..maxY) {
            for (x in minX..maxX) {
                val point = Point(x, y).apply {
                    closestBasePoint = findClosestBasePoint(basePoints, this)
                }
                grid.add(point)
            }
        }
    }

    private fun findClosestBasePoint(basePoints: List<Point>, point: Point): Point? {
        val basePointDistances = basePoints.map { Pair(it, getManhattanDistance(it, point)) }.toMap()
        val minDistance = basePointDistances.values.min()!!
        return if (basePointDistances.values.count { it == minDistance } == 1) {
            basePointDistances.filter { it.value == minDistance }.map { it.key }.single()
        } else null
    }

    private fun getManhattanDistance(a: Point, b: Point): Int {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y)
    }

    fun getSizeOfLargestFiniteArea(): Int {
        val infiniteBasePoints = mutableSetOf<Point>()
        for (point in grid) {
            if (point.x == min.x || point.x == max.x || point.y == min.y || point.y == max.y) {
                point.closestBasePoint?.let {
                    infiniteBasePoints.add(it)
                }
            }
        }
        return grid.filterNot { it.closestBasePoint == null }
            .filterNot { infiniteBasePoints.contains(it.closestBasePoint) }
            .groupingBy { it.closestBasePoint!! }
            .eachCount()
            .map { it.value }
            .max()!!
    }

}