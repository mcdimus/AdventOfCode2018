package eu.maksimov.advent.year2018.day3

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object FabricClaimSpek : Spek({
    describe("A FabricClaim") {
        it("can be constructed from spec") {
            val spec = "#123 @ 3,2: 5x4"
            val fabricClaim = FabricClaim.of(spec)
            assertThat(fabricClaim).isEqualTo(
                FabricClaim(
                    id = "123",
                    leftSpan = 3,
                    topSpan = 2,
                    width = 5,
                    height = 4
                )
            )
        }
    }
})