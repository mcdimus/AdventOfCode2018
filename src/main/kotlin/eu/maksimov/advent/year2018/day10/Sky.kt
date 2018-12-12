package eu.maksimov.advent.year2018.day10

class Sky(private val points: List<Point>) {

    // we are assuming that correct setup will have the minimal dimensions
    // thus we are searching for the minimum box dimensions
    fun printText() {
        var seconds = 0
        var count = 0
        var minBox = Int.MAX_VALUE
        var snapshot: List<Point> = emptyList()

        while (true) {
            count++
            points.forEach { it.applyVelocity() }
            val box = points.getHeight() + points.getLength()
            if (box < minBox) {
                seconds = count
                minBox = box
                snapshot = points.map { it.copy() }
            }
            if (count - seconds > 100) break // apparently there is not going to be any better case
        }
        println("Seconds warped: $seconds")

        val minY = snapshot.map { it.getY() }.min()!!
        val maxY = snapshot.map { it.getY() }.max()!!
        val minX = snapshot.map { it.getX() }.min()!!
        val maxX = snapshot.map { it.getX() }.max()!!

        for (y in minY..maxY) {
            for (x in minX..maxX) {
                if (snapshot.any { it.getX() == x && it.getY() == y }) print("#") else print(" ")
            }
            println()
        }
    }

    private fun List<Point>.getHeight(): Int {
        val minY = this.map { it.getY() }.min()!!
        val maxY = this.map { it.getY() }.max()!!

        return maxY - minY
    }

    private fun List<Point>.getLength(): Int {
        val minX = this.map { it.getX() }.min()!!
        val maxX = this.map { it.getX() }.max()!!

        return maxX - minX
    }

}
