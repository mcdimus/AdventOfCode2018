package eu.maksimov.advent.year2018.day9

class MarbleGame(val playersNum: Int, val lastMarble: Int) {

    private val board = MarbleBoard()
    private val players = (1..playersNum).map { Player(it) }

    fun play() {
        for (marble in 1..lastMarble) {
            val currentPlayer = players[(marble - 1) % playersNum]
            val score = board.placeMarble(marble)
            currentPlayer.addScore(score)
        }
    }

    fun getWinner(): Player = players.maxBy { it.getScore() }!!

}