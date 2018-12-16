package eu.maksimov.advent.year2018.day14

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object RecipeBoardSpek : Spek({
    describe("A RecipeBoard") {
        it("gets score") {
            val recipeBoard = RecipeBoard()

            val recipeTarget = 9
            while (true) {
                recipeBoard.makeNewRecipe()
                if (recipeBoard.board.size > recipeTarget + 10) {
                    break
                }
            }

            assertThat(recipeBoard.getScores(recipeTarget)).isEqualTo("5158916779")
        }
    }
})