package eu.maksimov.advent.year2018.day1

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object FrequencyResolverSpek : Spek({
    describe("A frequency resolver") {
        describe("non-repeating") {
            it("resolves given input") {
                val resolver1 = FrequencyResolver(listOf(1, 1, 1))
                assertThat(resolver1.resolve()).isEqualTo(3)

                val resolver2 = FrequencyResolver(listOf(-1, -2, -3))
                assertThat(resolver2.resolve()).isEqualTo(-6)
            }
        }

        describe("repeating") {
            it("returns first duplicated frequency") {
                val resolver1 = FrequencyResolver(listOf(+1, -1))
                assertThat(resolver1.resolveRepeating()).isEqualTo(0)

                val resolver2 = FrequencyResolver(listOf(+3, +3, +4, -2, -4))
                assertThat(resolver2.resolveRepeating()).isEqualTo(10)

                val resolver3 = FrequencyResolver(listOf(-6, +3, +8, +5, -6))
                assertThat(resolver3.resolveRepeating()).isEqualTo(5)

                val resolver4 = FrequencyResolver(listOf(+7, +7, -2, -7, -4))
                assertThat(resolver4.resolveRepeating()).isEqualTo(14)
            }
        }
    }
})