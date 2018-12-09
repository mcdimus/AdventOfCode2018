package eu.maksimov.advent.year2018.day7

class Step(val name: String) {

    companion object {
        private const val BASE_TIME_TO_COMPLETE = 60 // seconds
    }

    val timeToComplete: Int

    val prerequisites = mutableListOf<String>()

    val nextSteps = mutableListOf<String>()

    init {
        timeToComplete = BASE_TIME_TO_COMPLETE + (name.toCharArray().first() - 64).toInt()
    }

    fun isPrerequisitesCompleted(stepOrder: String): Boolean {
        return prerequisites.all { stepOrder.contains(it) }
    }

    override fun toString(): String {
        return "Step(name='$name', timeToComplete=$timeToComplete, prerequisites=$prerequisites, nextSteps=$nextSteps)"
    }


}
