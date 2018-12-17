package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

class Wall(point: Point) : MapObject(point, symbol = SYMBOL) {

    companion object {
        const val SYMBOL: Char = '#'
    }

}