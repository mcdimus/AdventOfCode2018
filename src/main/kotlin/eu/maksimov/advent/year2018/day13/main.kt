package eu.maksimov.advent.year2018.day13

import eu.maksimov.advent.year2018.shared.readResourceLines

fun main() {
    val lines = readResourceLines("day13_input")

    // part 1
    val rails = Rails(lines)

    try {
        while (true) {
            rails.tick()
        }
    } catch (collision: CollisionException) {
        println("First collision at ${collision.cart.x},${collision.cart.y}")
    }

    // part 2
    val rails2 = Rails(lines)

    while (rails2.carts.size > 1) {
        rails2.tickWithCollisionPrediction()
    }

    val lastCart = rails2.carts.first()

    println("Last cart at ${lastCart.x},${lastCart.y}")
}