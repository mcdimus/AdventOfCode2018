package eu.maksimov.advent.year2018.day7

object Clock {
    private var seconds: Int = 0

    fun tick() {
        seconds++
    }

    fun getSeconds() = seconds

}