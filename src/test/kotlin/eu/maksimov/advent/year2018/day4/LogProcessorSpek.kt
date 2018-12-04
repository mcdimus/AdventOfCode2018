package eu.maksimov.advent.year2018.day4

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object LogProcessorSpek : Spek({
    describe("A LogProcessor") {
        val logProcessor by memoized { LogProcessor() }

        it("creates correct log entries") {
            val input = listOf(
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-05 00:55] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:45] falls asleep"
            )

            val result = logProcessor.process(input)

            assertThat(result.map { it.toString() }).containsExactly(
                "1518-11-01  #10  .....####################.....#########################.....",
                "1518-11-02  #99  ........................................##########..........",
                "1518-11-03  #10  ........................#####...............................",
                "1518-11-04  #99  ....................................##########..............",
                "1518-11-05  #99  .............................................##########....."
            )
        }

        it("finds mediocre combination") {
            val input = listOf(
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-05 00:55] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:45] falls asleep"
            )

            val entries = logProcessor.process(input)
            var result = logProcessor.findMediocreGuardAndMinuteCombination(entries)

            assertThat(result).isEqualTo(Pair(10, 24))
        }

        it("finds best combination") {
            val input = listOf(
                "[1518-11-01 23:58] Guard #99 begins shift",
                "[1518-11-01 00:00] Guard #10 begins shift",
                "[1518-11-01 00:25] wakes up",
                "[1518-11-01 00:30] falls asleep",
                "[1518-11-01 00:55] wakes up",
                "[1518-11-02 00:50] wakes up",
                "[1518-11-05 00:55] wakes up",
                "[1518-11-03 00:05] Guard #10 begins shift",
                "[1518-11-03 00:24] falls asleep",
                "[1518-11-02 00:40] falls asleep",
                "[1518-11-05 00:03] Guard #99 begins shift",
                "[1518-11-03 00:29] wakes up",
                "[1518-11-04 00:02] Guard #99 begins shift",
                "[1518-11-01 00:05] falls asleep",
                "[1518-11-04 00:36] falls asleep",
                "[1518-11-04 00:46] wakes up",
                "[1518-11-05 00:45] falls asleep"
            )

            val entries = logProcessor.process(input)
            var result = logProcessor.findBestGuardAndMinuteCombination(entries)

            assertThat(result).isEqualTo(Pair(99, 45))
        }
    }
})