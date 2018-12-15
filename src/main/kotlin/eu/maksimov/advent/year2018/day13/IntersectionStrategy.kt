package eu.maksimov.advent.year2018.day13

enum class IntersectionStrategy {

    TURN_LEFT {
        override val next get() = CONTINUE_STRAIGHT
    },
    TURN_RIGHT {
        override val next get() = TURN_LEFT
    },
    CONTINUE_STRAIGHT {
        override val next get() = TURN_RIGHT
    };

    abstract val next: IntersectionStrategy

}