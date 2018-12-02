package eu.maksimov.advent.year2018.day2

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BoxSpek : Spek({
    describe("A Box") {
        describe("id contains no duplicate chars") {
            val box by memoized { Box("abcdef") }
            it("not countsForTwo") {
                assertFalse { box.countsForTwo }
            }
            it("not countsForThree") {
                assertFalse { box.countsForThree }
            }
        }

        describe("id contains doubled chars") {
            it("countsForTwo if single occurrence") {
                val box = Box("abbcde")
                assertTrue { box.countsForTwo }
                assertFalse { box.countsForThree }
            }
            it("countsForTwo if double occurrence") {
                val box = Box("aabcdd")
                assertTrue { box.countsForTwo }
                assertFalse { box.countsForThree }
            }
        }

        describe("id contains tripled chars") {
            it("countsForThree if single occurrence") {
                val box = Box("abcccd")
                assertFalse { box.countsForTwo }
                assertTrue { box.countsForThree }
            }
            it("countsForTwo if double occurrence") {
                val box = Box("aaabbb")
                assertFalse { box.countsForTwo }
                assertTrue { box.countsForThree }
            }
        }
        describe("id contains doubled and tripled chars") {
            it("countsForTwo and forThree") {
                val box = Box("bababc")
                assertTrue { box.countsForTwo }
                assertTrue { box.countsForThree }
            }
        }
    }
})