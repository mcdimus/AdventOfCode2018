package eu.maksimov.advent.year2018.day7

class Step(val name: String) {

    val prerequisites = mutableListOf<String>()

    val nextSteps = mutableListOf<String>()

    fun isPrerequisitesCompleted(stepOrder: String): Boolean {
        return prerequisites.all { stepOrder.contains(it) }
    }

}
