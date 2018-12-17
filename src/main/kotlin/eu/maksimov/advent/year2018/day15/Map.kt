package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Point

class Map(lines: List<String>) {

    private val map: Array<Array<MapObject>> =
        Array(lines.size) { y -> Array(lines.first().length) { x -> Wall(Point(x, y)) as MapObject } }

    init {
        for ((y, line) in lines.withIndex()) {
            for ((x, symbol) in line.withIndex()) {
                if (symbol == Wall.SYMBOL) continue

                map[y][x] = MapObject.create(x, y, symbol)
            }
        }
    }

    fun print() {
        for (row in map) {
            val creatures = mutableListOf<Creature>()
            for (mapObject in row) {
                if (mapObject is Creature) {
                    creatures.add(mapObject)
                }
                print(mapObject.symbol)
            }
            print("  " + creatures.joinToString(separator = ", ") { "${it.symbol}(${it.hp})" })
            println()
        }
    }

    fun findAllCreatures() = map.flatMap { it.asIterable() }
        .filter { it is Creature }
        .map { it as Creature }

}