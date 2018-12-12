package eu.maksimov.advent.year2018.day9

import eu.maksimov.advent.year2018.shared.rotate
import java.util.*

class MarbleBoard {

    val marbles = ArrayDeque<Int>().apply { offer(0) }

    fun placeMarble(marble: Int): Int {
        if (marble % 23 == 0) {
            marbles.rotate(-7)
            return marbles.pop() + marble
        }

        marbles.rotate(2)
        marbles.offer(marble)

        return 0
    }

}