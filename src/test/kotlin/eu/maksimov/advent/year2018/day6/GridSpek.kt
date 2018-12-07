package eu.maksimov.advent.year2018.day6

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GridSpek : Spek({
    describe("A Grid") {
        it("finds correct largest finite area size") {
            val basePoints = listOf(
                Point(1, 1),
                Point(1, 6),
                Point(8, 3),
                Point(3, 4),
                Point(5, 5),
                Point(8, 9)
            )
            val grid = Grid(basePoints)

            assertThat(grid.getSizeOfLargestFiniteArea()).isEqualTo(17)
        }
    }
})