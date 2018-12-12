package eu.maksimov.advent.year2018.day11

data class Cell(val x: Int, val y: Int, private val serialNumber: Int) {

    fun getPowerLevel(): Int {
        val rackId = x + 10
        val tempVal = (rackId * y + serialNumber) * rackId
        val hundredsDigit = tempVal / 100 % 10
        return hundredsDigit - 5
    }

}