package eu.maksimov.advent.year2018.day7

import java.util.*

class Instructions {

    private val steps = mutableListOf<Step>()

    fun addStep(stepName: String, dependentStepName: String) {
        val step = steps.find { it.name == stepName }
        if (step == null) {
            val newStep = Step(stepName).apply {
                nextSteps.add(dependentStepName)
            }
            steps.add(newStep)
        } else {
            step.nextSteps.add(dependentStepName)
        }

        val dependentStep = steps.find { it.name == dependentStepName }
        if (dependentStep == null) {
            val newStep = Step(dependentStepName).apply {
                prerequisites.add(stepName)
            }
            steps.add(newStep)
        } else {
            dependentStep.prerequisites.add(stepName)
        }
    }

    fun getStepsOrder(): String {
        val availableSteps = object : PriorityQueue<String>() {
            override fun offer(e: String?) = when {
                contains(e) -> false
                else -> super.offer(e)
            }
        }
        steps.filter { it.prerequisites.isEmpty() }.forEach { availableSteps.add(it.name) }

        var stepOrder = ""
        while (availableSteps.isNotEmpty()) {
            val currentStepName = availableSteps.poll()
            val currentStep = steps.first { it.name == currentStepName }
            if (currentStep.isPrerequisitesCompleted(stepOrder)) {
                stepOrder += currentStep.name
                availableSteps.addAll(currentStep.nextSteps)
            }
        }

        return stepOrder
    }

}