package eu.maksimov.advent.year2018.day13

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RailsSpek : Spek({
    describe("A Rails") {
        it("works") {
            val rails = Rails(
                listOf(
                    "/->-\\",
                    "|   |  /----\\",
                    "| /-+--+-\\  |",
                    "| | |  | v  |",
                    "\\-+-/  \\-+--/",
                    "\\------/"
                )
            )
            try {
                while (true) {
                    rails.tick()
                }
            } catch (e: CollisionException) {
                assertThat(e.cart.x).isEqualTo(7)
                assertThat(e.cart.y).isEqualTo(3)
            }
        }

        it("works part 2") {
            val rails = Rails(
                listOf(
                    "/>-<\\  ",
                    "|   |  ",
                    "| /<+-\\",
                    "| | | v",
                    "\\>+</ |",
                    "  |   ^",
                    "  \\<->/"
                )
            )
            while (rails.carts.size > 1) {
                rails.tickWithCollisionPrediction()
            }
            assertThat(rails.carts.first().x).isEqualTo(6)
            assertThat(rails.carts.first().y).isEqualTo(4)

        }
    }
})