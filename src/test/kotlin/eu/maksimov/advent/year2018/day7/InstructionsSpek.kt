package eu.maksimov.advent.year2018.day7

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object InstructionsSpek : Spek({

    describe("An Instructions") {
        val instructions by memoized {
            Instructions().apply {
                addStep("C", "A")
                addStep("C", "F")
                addStep("A", "B")
                addStep("A", "D")
                addStep("B", "E")
                addStep("D", "E")
                addStep("F", "E")
            }
        }

        it("calculates correct steps order") {
            val result = instructions.getStepsOrder()

            assertThat(result).isEqualTo("CABDFE")
        }

        it("calculates duration with 2 workers") {
            val result = instructions.getDurationWithParallelWorkers(2)

            assertThat(result).isEqualTo(258)
        }
    }

})