package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

abstract class MapObject(var point: Point, val symbol: Char) {

    companion object {
        fun create(x: Int, y: Int, symbol: Char): MapObject {
            val point = Point(x, y)
            return when (symbol) {
                '#' -> Wall(point)
                '.' -> Cavern(point)
                'E' -> Elf(point)
                'G' -> Goblin(point)
                else -> throw IllegalArgumentException("Unsupported map object: $symbol at $point")
            }
        }
    }

}