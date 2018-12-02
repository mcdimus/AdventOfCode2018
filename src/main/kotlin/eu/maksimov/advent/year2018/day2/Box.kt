package eu.maksimov.advent.year2018.day2

data class Box(val id: String) {

    val countsForTwo: Boolean
    val countsForThree: Boolean

    init {
        val charsCount = id.groupingBy { it }.eachCount()
        countsForTwo = charsCount.containsValue(2)
        countsForThree = charsCount.containsValue(3)
    }

    fun distance(other: Box): Int {
        var distance = 0
        this.id.forEachIndexed { index, char ->
            if (char != other.id[index])
                distance++
        }
        return distance
    }

    fun commonLetters(other: Box): String {
        var commonLetters = ""
        this.id.forEachIndexed { index, char ->
            if (char == other.id[index])
                commonLetters += char
        }
        return commonLetters
    }

}