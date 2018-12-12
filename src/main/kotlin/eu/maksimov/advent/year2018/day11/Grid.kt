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

    fun getMostPowerfulSquareCoords(squareSize: Int): SquareData {
        var bestSum = Int.MIN_VALUE
        var bestSumCoords = Int.MIN_VALUE to Int.MIN_VALUE

        for (y in 0..(SIZE - squareSize)) {
            for (x in 0..(SIZE - squareSize)) {
                var sum = 0
                for (y1 in y until (y + squareSize)) {
                    for (x1 in x until (x + squareSize)) {
                        sum += powerLevels[y1][x1]
                    }
                }
                if (sum > bestSum) {
                    bestSum = sum
                    bestSumCoords = x to y
                }
            }
        }

        return SquareData(
            x = bestSumCoords.first,
            y = bestSumCoords.second,
            power = bestSum,
            size = squareSize
        )
    }

    fun getMostPowerfulSquare(): SquareData {
        return (1..SIZE).map { getMostPowerfulSquareCoords(it) }.maxBy { it.power }!!
    }

}