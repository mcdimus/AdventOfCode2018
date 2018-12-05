package eu.maksimov.advent.year2018.day5

class Polymer(private val value: String) {

    companion object {
        private const val DIFF_BETWEEN_CAPITAL_AND_NON_CAPITAL_LETTER = 32
    }

    fun getValue() = value

    fun simplify(): Polymer {
        var value = this.value
        var currentIndex = 0
        while (currentIndex < value.length - 1) {
            val currentUnit = value[currentIndex]
            val nextUnit = value[currentIndex + 1]
            if (isSameCharWithDifferentRegistry(currentUnit, nextUnit)) {
                value = value.replaceRange(currentIndex, currentIndex + 2, "")
                if (currentIndex > 0) currentIndex--
            } else {
                currentIndex++
            }
        }
        return Polymer(value)
    }

    private fun isSameCharWithDifferentRegistry(a: Char, b: Char) =
        Math.abs(a - b) == DIFF_BETWEEN_CAPITAL_AND_NON_CAPITAL_LETTER

    fun enhance(): Polymer {
        return CharRange('a', 'z').asSequence()
            .map { value.replace(it.toString(), "", ignoreCase = true) }
            .map { Polymer(it).simplify() }
            .minBy { it.getValue().length }!!
    }

}