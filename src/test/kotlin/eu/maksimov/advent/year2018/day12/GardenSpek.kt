package eu.maksimov.advent.year2018.day12

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object GardenSpek : Spek({
    describe("A Garden") {
        it("evolves correctly") {
            val garden = Garden(initialState = "#..#.#..##......###...###", rules = listOf(
                "...## => #",
                "..#.. => #",
                ".#... => #",
                ".#.#. => #",
                ".#.## => #",
                ".##.. => #",
                ".#### => #",
                "#.#.# => #",
                "#.### => #",
                "##.#. => #",
                "##.## => #",
                "###.. => #",
                "###.# => #",
                "####. => #"
            ).map { Rule(it) }
            )

            garden.evolve()

            assertThat(garden.getCurrentState()).contains("...#...#....#.....#..#..#..#...........")
            assertThat(garden.countPlantsThroughtoutGenerateion()).isEqualTo(18)

            garden.evolve()

            assertThat(garden.getCurrentState()).contains("...##..##...##....#..#..#..##..........")
            assertThat(garden.countPlantsThroughtoutGenerateion()).isEqualTo(29)

            for (i in 1..18) {
                garden.evolve()
            }
            assertThat(garden.sumOfPotNumberContainingPlant()).isEqualTo(325)

        }
    }
})