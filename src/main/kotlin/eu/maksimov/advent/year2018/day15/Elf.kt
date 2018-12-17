package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

class Elf(point: Point) : Creature(point, symbol = 'E') {

    override fun identifyTargets(creatures: List<Creature>) = creatures.filter { it is Goblin }

}