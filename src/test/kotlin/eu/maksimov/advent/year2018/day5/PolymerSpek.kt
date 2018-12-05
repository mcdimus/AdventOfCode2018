package eu.maksimov.advent.year2018.day5

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object PolymerSpek : Spek({
    describe("A Polymer") {
        val polymer by memoized { Polymer("dabAcCaCBAcCcaDA") }

        it("gets simplified") {
            val simplifiedPolymer = polymer.simplify()

            assertThat(simplifiedPolymer.getValue()).isEqualTo("dabCBAcaDA")
        }

        it("gets enhanced") {
            val enhancedPolymer = polymer.enhance()

            assertThat(enhancedPolymer.getValue()).isEqualTo("daDA")
        }
    }
})