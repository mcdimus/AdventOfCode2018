package eu.maksimov.advent.year2018.day12

data class Garden(private val initialState: String, private val rules: List<Rule>) {

    private var currentState: HashMap<Int, Boolean>
    private val rulesMap = rules.map { it.patternStr to it.result }.toMap()

    private var minPotNum = -2
    private var maxPotNum = initialState.length + 1

    init {
        currentState = HashMap()
        initialState.map { it == '#' }.forEachIndexed { potNum, hasPlant -> currentState[potNum] = hasPlant }
    }

    fun evolve() {
        val nextState = HashMap<Int, Boolean>()


        for (potNum in minPotNum..maxPotNum) {
            val potNeighborhood =
                if (currentState[potNum - 2] == true) "#" else {
                    "."
                } +
                        if (currentState[potNum - 1] == true) "#" else {
                            "."
                        } +
                        if (currentState[potNum] == true) "#" else {
                            "."
                        } +
                        if (currentState[potNum + 1] == true) "#" else {
                            "."
                        } +
                        if (currentState[potNum + 2] == true) "#" else {
                            "."
                        }


            val hasPlantInNextGen = rulesMap[potNeighborhood] ?: false
            nextState[potNum] = hasPlantInNextGen
        }
        if (nextState[minPotNum] == true) {
            minPotNum -= 2
        } else if (nextState[minPotNum + 1] == true) {
            minPotNum -= 1
        }
        if (nextState[maxPotNum] == true) {
            maxPotNum += 2
        } else if (nextState[maxPotNum - 1] == true) {
            maxPotNum += 1
        }
        currentState = nextState
    }

    fun sumOfPotNumberContainingPlant(): Int {
        return currentState.filterValues { it }.keys.sum()
    }

    fun getCurrentState(): String {
        return ""
    }

}