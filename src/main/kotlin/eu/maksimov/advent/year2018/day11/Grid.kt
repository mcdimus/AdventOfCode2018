package eu.maksimov.advent.year2018.day11

data class Grid(val serialNumber: Int) {

    companion object {
        private const val SIZE = 300
    }

    private val powerLevels: Array<Array<Int>> = Array(SIZE) { Array(SIZE) { 0 } }

    init {
        for (y in 0 until SIZE) {
            for (x in 0 until SIZE) {
                powerLevels[y][x] = Cell(x, y, serialNumber).getPowerLevel()
            }
        }
    }

    fun getMostPowerfulSquareCoords(): Pair<Int, Int> {
        var bestSum = Int.MIN_VALUE
        var bestSumCoords = Int.MIN_VALUE to Int.MIN_VALUE

        for (y in 0..(SIZE - 3)) {
            for (x in 0..(SIZE - 3)) {
                var sum = 0
                for (y1 in y..(y + 2)) {
                    for (x1 in x..(x + 2)) {
                        sum += powerLevels[y1][x1]
                    }
                }
                if (sum > bestSum) {
                    bestSum = sum
                    bestSumCoords = x to y
                }
            }
        }

        return bestSumCoords
    }
}