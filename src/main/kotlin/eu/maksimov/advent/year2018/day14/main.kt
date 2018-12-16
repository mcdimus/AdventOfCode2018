package eu.maksimov.advent.year2018.day14

fun main() {
    val input = "084601"

    val recipeBoard = RecipeBoard()

    val recipeTarget = input.toInt()

    while (true) {
        recipeBoard.makeNewRecipe()
        if (recipeBoard.board.size > recipeTarget + 10) {
            break
        }
    }

    // part 1
    println("What are the scores of the ten recipes immediately after the number of recipes in your puzzle input?")
    println(recipeBoard.getScores(recipeTarget))

    // part 2
    val recipeBoard2 = RecipeBoard()

    while (true) {
        recipeBoard2.makeNewRecipe()
        if (recipeBoard2.ending.startsWith(input)) {
            println(recipeBoard2.board.size - input.length) // 20188250
            break
        }
    }

}