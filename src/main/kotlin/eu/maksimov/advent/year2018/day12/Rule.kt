package eu.maksimov.advent.year2018.day12

data class Rule(private val value: String) {

    val patternStr: String = value.substringBefore(" => ")
    val pattern: Array<Boolean> = Array(5) { false }
    val result: Boolean


    init {
        patternStr.map { it == '#' }
            .forEachIndexed { potNum, hasPlant -> pattern[potNum] = hasPlant }
        result = value.substringAfter(" => ") == "#"
    }


}