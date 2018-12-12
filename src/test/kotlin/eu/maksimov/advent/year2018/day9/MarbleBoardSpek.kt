package eu.maksimov.advent.year2018.day9

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object MarbleBoardSpek : Spek({
    describe("A MarbleBoard") {
        it("correctly places basic marbles with resulting zero score") {
            val board = MarbleBoard()

            assertThat(board.placeMarble(1)).isZero()
            assertThat(board.marbles).containsExactly(0, 1)

            assertThat(board.placeMarble(2)).isZero()
            assertThat(board.marbles).containsExactly(0, 2, 1)

            assertThat(board.placeMarble(3)).isZero()
            assertThat(board.marbles).containsExactly(0, 2, 1, 3)

            assertThat(board.placeMarble(4)).isZero()
            assertThat(board.marbles).containsExactly(0, 4, 2, 1, 3)
        }

        it("correctly places 23rd marble with resulting score") {
            val board = MarbleBoard()
            (1..22).forEach { board.placeMarble(it) }

            assertThat(board.placeMarble(23)).isEqualTo(32)
            assertThat(board.marbles)
                .containsExactly(0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15)
        }
    }
})