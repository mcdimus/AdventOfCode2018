package eu.maksimov.advent.year2018.day5

class Polymer(private val value: String) {

    companion object {
        private const val LETTERS_COUNT = 26
        private const val DIFF_BETWEEN_CAPITAL_AND_NON_CAPITAL_LETTER = 32
    }

    fun simplify(): Polymer {
        var value = this.value
        var currentIndex = 0
        while (currentIndex < value.length - 1) {
            val currentUnit = value[currentIndex]
            val previousUnit = value[currentIndex + 1]
            if (isSameCharWithDifferentRegistry(previousUnit, currentUnit)) {
                value = value.replaceRange(currentIndex, currentIndex + 2, "")
                if (currentIndex > 0) currentIndex--
            } else {
                currentIndex++
            }
        }
        return Polymer(value)
    }

    private fun isSameCharWithDifferentRegistry(previousUnit: Char, currentUnit: Char) =
        Math.abs(previousUnit - currentUnit) == DIFF_BETWEEN_CAPITAL_AND_NON_CAPITAL_LETTER

    fun getValue() = value

    fun enhance(): Polymer {
        return generateSequence({ 'a' }, { it + 1 }).take(LETTERS_COUNT).asSequence()
            .map { value.replace(it.toString(), "", ignoreCase = true) }
            .map { Polymer(it).simplify() }
            .minBy { it.getValue().length }!!
    }

}