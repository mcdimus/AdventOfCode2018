package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

abstract class Creature(
    point: Point,
    symbol: Char,
    var hp: Int = 200,
    val attackPower: Int = 3
) : MapObject(point, symbol), Comparable<Creature> {

    abstract fun identifyTargets(creatures: List<Creature>): List<Creature>

    override fun compareTo(other: Creature) = this.point.compareTo(other.point)

    fun isAlive() = hp > 0

    fun attack(target: Creature) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}