package eu.maksimov.advent.year2018.day2

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

class CorrectBoxesFinderSpek : Spek({
    describe("A CorrectBoxesFinder") {
        val boxes by memoized {
            listOf(
                Box("abcde"),
                Box("fghij"),
                Box("klmno"),
                Box("pqrst"),
                Box("fguij"),
                Box("axcye"),
                Box("wvxyz")
            )
        }
        it("find correct letters") {
            val correctBoxesFinder = CorrectBoxesFinder(boxes)
            assertThat(correctBoxesFinder.getCommonLetters()).isEqualTo("fgij")
        }
    }
})