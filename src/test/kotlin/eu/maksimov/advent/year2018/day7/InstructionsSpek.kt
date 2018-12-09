package eu.maksimov.advent.year2018.day7

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object InstructionsSpek : Spek({

    describe("An Instructions") {
        it("calculates correct steps order") {
            val instructions = Instructions()

            instructions.addStep("C", "A")
            instructions.addStep("C", "F")
            instructions.addStep("A", "B")
            instructions.addStep("A", "D")
            instructions.addStep("B", "E")
            instructions.addStep("D", "E")
            instructions.addStep("F", "E")

            val result = instructions.getStepsOrder()

            assertThat(result).isEqualTo("CABDFE")
        }
    }

})