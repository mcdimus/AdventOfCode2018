package eu.maksimov.advent.year2018.day1

class FrequencyResolver(private val input: List<Int>) {

    fun resolve(): Int {
        return input.sum()
    }

    fun resolveRepeating(): Int {
        var currentFrequency = 0
        val frequencies = HashSet<Int>()
        frequencies.add(currentFrequency)

        generateSequence(0) { (it + 1) % input.size }.forEach {
            currentFrequency += input[it]
            if (!frequencies.add(currentFrequency)) {
                return currentFrequency
            }
        }
        return currentFrequency
    }

}

