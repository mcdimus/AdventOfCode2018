package eu.maksimov.advent.year2018.day9

data class Player(val id: Int) {

    private var score = 0L

    fun addScore(value: Int) {
        score += value
    }

    fun getScore() = score

}