package eu.maksimov.advent.year2018.day15

import eu.maksimov.advent.year2018.shared.Direction

class Battleground(val map: Map) {

    var battlegroundStatus = BattlegroundStatus.ACTIVE

    var fullRoundsCount = 0

    fun playRound() {
        val creatures = map.findAllCreatures().sorted()

        for (creature in creatures) {
            val targets = creature.identifyTargets(creatures)

            if (targets.isEmpty()) {
                battlegroundStatus = BattlegroundStatus.FINISHED
                return
            }

            val targetInRange = getTargetInRangeWithHighestPriority(creature, targets)
            if (targetInRange != null) {
                creature.attack(targetInRange)
            } else {
                // move
            }

        }

        fullRoundsCount++
    }

    private fun getTargetInRangeWithHighestPriority(creature: Creature, targets: List<Creature>): Creature? {
        val adjacentPoints = Direction.values().map { it.apply(creature.point) }.toSet()
        return targets.find { adjacentPoints.contains(it.point) }
    }

}