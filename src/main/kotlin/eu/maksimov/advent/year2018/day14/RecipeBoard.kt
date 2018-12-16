package eu.maksimov.advent.year2018.day14

class RecipeBoard {

    val board = mutableListOf(3, 7)

    var ending: String = "XXXXXXX"
    var currentRecipeIndex1 = 0
    var currentRecipeIndex2 = 1

    fun makeNewRecipe() {
        val newRecipe = board[currentRecipeIndex1] + board[currentRecipeIndex2]
        if (newRecipe >= 10) {
            board.add(1)
            board.add(newRecipe - 10)
        } else {
            board.add(newRecipe)
        }
        ending = ending.push(newRecipe.toString())

        currentRecipeIndex1 = (board[currentRecipeIndex1] + 1 + currentRecipeIndex1) % board.size
        currentRecipeIndex2 = (board[currentRecipeIndex2] + 1 + currentRecipeIndex2) % board.size
    }

    fun getScores(from: Int): String {
        return board.subList(from, from + 10).joinToString(separator = "")
    }

    fun String.push(value: String) = this.substring(value.length) + value
}