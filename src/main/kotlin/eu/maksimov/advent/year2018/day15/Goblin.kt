package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

class Goblin(point: Point) : Creature(point, symbol = 'G') {

    override fun identifyTargets(creatures: List<Creature>) = creatures.filter { it is Elf }

}