package eu.maksimov.advent.year2018.day13

enum class CartFaceDirection(val symbol: Char) {

    UP('^') {
        override fun turn(track: Char, onIntersection: IntersectionStrategy): CartFaceDirection {
            when (track) {
                '/' -> return RIGHT
                '\\' -> return LEFT
                '+' -> when (onIntersection) {
                    IntersectionStrategy.TURN_LEFT -> return LEFT
                    IntersectionStrategy.TURN_RIGHT -> return RIGHT
                }
            }
            return this
        }
    },
    DOWN('v') {
        override fun turn(track: Char, onIntersection: IntersectionStrategy): CartFaceDirection {
            when (track) {
                '/' -> return LEFT
                '\\' -> return RIGHT
                '+' -> when (onIntersection) {
                    IntersectionStrategy.TURN_LEFT -> return RIGHT
                    IntersectionStrategy.TURN_RIGHT -> return LEFT
                }
            }
            return this
        }
    },
    LEFT('<') {
        override fun turn(track: Char, onIntersection: IntersectionStrategy): CartFaceDirection {
            when (track) {
                '/' -> return DOWN
                '\\' -> return UP
                '+' -> when (onIntersection) {
                    IntersectionStrategy.TURN_LEFT -> return DOWN
                    IntersectionStrategy.TURN_RIGHT -> return UP
                }
            }
            return this
        }
    },
    RIGHT('>') {
        override fun turn(track: Char, onIntersection: IntersectionStrategy): CartFaceDirection {
            when (track) {
                '/' -> return UP
                '\\' -> return DOWN
                '+' -> when (onIntersection) {
                    IntersectionStrategy.TURN_LEFT -> return UP
                    IntersectionStrategy.TURN_RIGHT -> return DOWN
                }
            }
            return this
        }
    };

    abstract fun turn(track: Char, onIntersection: IntersectionStrategy): CartFaceDirection

    companion object {
        fun of(char: Char) = values().singleOrNull { it.symbol == char }
    }

}