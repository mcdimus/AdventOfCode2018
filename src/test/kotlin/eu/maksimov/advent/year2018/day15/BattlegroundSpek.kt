package eu.maksimov.advent.year2018.day15

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object BattlegroundSpek : Spek({
    describe("A Battleground") {
        it("draws map") {
            val map = Map(
                listOf(
                    "#########",
                    "#G..G..G#",
                    "#.......#",
                    "#.......#",
                    "#G..E..G#",
                    "#.......#",
                    "#.......#",
                    "#G..G..G#",
                    "#########"
                )
            )

            map.print()
        }
    }
})