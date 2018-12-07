package eu.maksimov.advent.year2018.day6

class Grid(private val basePoints: List<Point>, private val safeRegionMaxDistance: Int) {

    private val min: Point
    private val max: Point
    private val points: MutableList<Point> = arrayListOf()

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
                points.add(point)
            }
        }
    }

    private fun findClosestBasePoint(basePoints: List<Point>, point: Point): Point? {
        val basePointDistances = basePoints.map { it to it.manhattanDistanceTo(point) }.toMap()
        val minDistance = basePointDistances.values.min()!!
        return if (basePointDistances.values.count { it == minDistance } == 1) {
            basePointDistances.filter { it.value == minDistance }.map { it.key }.single()
        } else null
    }

    fun getSizeOfLargestFiniteArea(): Int {
        val infiniteBasePoints = points.asSequence()
            .filter { it.x == min.x || it.x == max.x || it.y == min.y || it.y == max.y }
            .mapNotNull { it.closestBasePoint }
            .toSet()

        return points.filterNot { it.closestBasePoint == null }
            .filterNot { infiniteBasePoints.contains(it.closestBasePoint) }
            .groupingBy { it.closestBasePoint!! }
            .eachCount()
            .map { it.value }
            .max()!!
    }

    fun getSafeRegionSize(): Int {
        return points.map { point -> basePoints.sumBy { basePoint -> point.manhattanDistanceTo(basePoint) } }
            .filter { it < safeRegionMaxDistance }
            .count()
    }

}