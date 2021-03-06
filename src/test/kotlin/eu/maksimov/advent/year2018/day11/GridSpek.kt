package eu.maksimov.advent.year2018.day11

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GridSpek : Spek({
    describe("A Grid") {
        it("finds coords of best square with size 3") {
            val grid = Grid(18)

            assertThat(grid.getMostPowerfulSquareCoords(3)).isEqualTo(33 to 45)
        }
    }
})
