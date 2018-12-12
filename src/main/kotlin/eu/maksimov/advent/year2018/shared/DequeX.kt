package eu.maksimov.advent.year2018.shared

import java.util.*

fun <T> Deque<T>.rotate(distance: Int) {
    when {
        distance == 0 -> return
        distance > 0 -> for (i in 1..distance) {
            this.offerFirst(this.pollLast())
        }
        distance < 0 -> for (i in 1..(Math.abs(distance) - 1)) {
            this.offerLast(this.pollFirst())
        }
    }
}