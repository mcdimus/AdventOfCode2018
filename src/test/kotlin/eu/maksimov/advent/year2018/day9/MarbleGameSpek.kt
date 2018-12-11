package eu.maksimov.advent.year2018.day9

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import java.util.*
import kotlin.system.measureTimeMillis

object MarbleGameSpek : Spek({
    describe("A MarbleGame") {
        it("finds a winner for 9 players and 25 marbles") {
            val marbleGame = MarbleGame(playersNum = 9, lastMarble = 25)
            marbleGame.play()

            assertThat(marbleGame.getWinner().id).isEqualTo(5)
            assertThat(marbleGame.getWinner().getScore()).isEqualTo(32)
        }

        it("finds a high score for 10 players and 1618 marbles") {
            val marbleGame = MarbleGame(playersNum = 10, lastMarble = 1618)
            marbleGame.play()

            assertThat(marbleGame.getWinner().getScore()).isEqualTo(8317)
        }

        it("finds a high score for 13 players and 7999 marbles") {
            val marbleGame = MarbleGame(playersNum = 13, lastMarble = 7999)
            marbleGame.play()

            assertThat(marbleGame.getWinner().getScore()).isEqualTo(146373)
        }

        it("modulo") {
            val arrayList = ArrayList<Int>(7_149_800)
            val measureTimeMillis = measureTimeMillis {
                for (i in 1..7_149_800) {
                    arrayList.add(if (i < 10) 0 else i - 7, i % 23)
                }
            }
            println(arrayList.sum())
            println("measureTimeMillis = ${measureTimeMillis}")
        }
    }
})