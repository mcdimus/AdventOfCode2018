package eu.maksimov.advent.year2018.day11

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object CellSpek : Spek({
    describe("A cell") {
        it("calculates power level") {
            val cell1 = Cell(x = 122, y = 79, serialNumber = 57)
            assertThat(cell1.getPowerLevel()).isEqualTo(-5)

            val cell2 = Cell(x = 217, y = 196, serialNumber = 39)
            assertThat(cell2.getPowerLevel()).isEqualTo(0)

            val cell3 = Cell(x = 101, y = 153, serialNumber = 71)
            assertThat(cell3.getPowerLevel()).isEqualTo(4)
        }
    }
})