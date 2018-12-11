package eu.maksimov.advent.year2018.day8

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object NodeSpek : Spek({
    describe("A Node") {
        it("created with zero children") {
            val result = Node(0, 3, 10, 11, 12)

            assertThat(result.childrenN).isEqualTo(0)
            assertThat(result.metadataN).isEqualTo(3)
            assertThat(result.children).isEmpty()
            assertThat(result.metadata).containsExactly(10, 11, 12)
        }

        it("created with one child (with zero children)") {
            val result = Node(1, 1, 0, 1, 99, 2)

            assertThat(result.childrenN).isEqualTo(1)
            assertThat(result.metadataN).isEqualTo(1)
            assertThat(result.children).containsExactly(Node(0, 1, 99))
            assertThat(result.metadata).containsExactly(2)
        }

        it("created with more complex hierarchy") {
            val result = Node(2, 3, 0, 3, 10, 11, 12, 1, 1, 0, 1, 99, 2, 1, 1, 2)

            assertThat(result.childrenN).isEqualTo(2)
            assertThat(result.metadataN).isEqualTo(3)
            assertThat(result.children).containsExactly(
                Node(0, 3, 10, 11, 12),
                Node(1, 1, 0, 1, 99, 2)
            )
            assertThat(result.metadata).containsExactly(1, 1, 2)
            assertThat(result.checksum()).isEqualTo(138)

            assertThat(result.value()).isEqualTo(66)
        }
    }
})