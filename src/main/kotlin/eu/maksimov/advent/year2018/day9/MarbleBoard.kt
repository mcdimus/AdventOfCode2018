package eu.maksimov.advent.year2018.day9

import java.util.*

class MarbleBoard() {

    private var capacity = 10_000

    constructor(capacity: Int) : this() {
        this.capacity = capacity
    }

    val marbles = LinkedList<Int>().apply { add(0) }

    var currentMarbleIndex = 0

    fun placeMarble(marble: Int): Int {
//        if (marble % 10_000 == 0) {
//            println(marble)
//        }
        if (marble % 23 == 0) {
            var indexForRemoval = currentMarbleIndex - 7
            if (indexForRemoval < 0) {
                indexForRemoval += marbles.size
            }
            val removedMarble = marbles.removeAt(indexForRemoval)
            currentMarbleIndex = indexForRemoval
            return removedMarble + marble
        }

        var newMarbleIndex = currentMarbleIndex + 2
        if (marbles.lastIndex == currentMarbleIndex) {
            newMarbleIndex -= marbles.size
        }

        marbles.add(newMarbleIndex, marble)
        currentMarbleIndex = newMarbleIndex

        return 0
    }

}