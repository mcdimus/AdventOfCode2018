package eu.maksimov.advent.year2018.day3

import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it

object FabricModelSpek : Spek({
    describe("A FabricModel") {
        describe("addition") {
            it("adds a single claim") {
                val fabricModel = FabricModel(10)
                val claim = FabricClaim(id = "1", leftSpan = 2, topSpan = 3, width = 4, height = 5)

                fabricModel.add(claim)

                assertThat(fabricModel.countIntersected()).isZero()
                assertThat(fabricModel.fabric).containsExactly(
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.')
                )
            }

            it("adds claims without intersection") {
                val fabricModel = FabricModel(10)
                val claim1 = FabricClaim(id = "1", leftSpan = 2, topSpan = 3, width = 4, height = 5)
                val claim2 = FabricClaim(id = "2", leftSpan = 0, topSpan = 1, width = 2, height = 2)

                fabricModel.add(claim1).add(claim2)

                assertThat(fabricModel.countIntersected()).isZero()
                assertThat(fabricModel.fabric).containsExactly(
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.')
                )
            }

            it("adds claims with intersection") {
                val fabricModel = FabricModel(10)
                val claim1 = FabricClaim(id = "1", leftSpan = 2, topSpan = 3, width = 4, height = 5)
                val claim2 = FabricClaim(id = "2", leftSpan = 0, topSpan = 1, width = 4, height = 4)

                fabricModel.add(claim1).add(claim2)

                assertThat(fabricModel.countIntersected()).isEqualTo(4)
                assertThat(fabricModel.fabric).containsExactly(
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '#', '#', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '#', '#', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('#', '#', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.')
                )
            }

            it("adds claims with multiple intersection") {
                val fabricModel = FabricModel(10)
                val claim1 = FabricClaim(id = "1", leftSpan = 2, topSpan = 3, width = 4, height = 5)
                val claim2 = FabricClaim(id = "2", leftSpan = 0, topSpan = 1, width = 4, height = 4)
                val claim3 = FabricClaim(id = "3", leftSpan = 0, topSpan = 3, width = 4, height = 4)
                val claim4 = FabricClaim(id = "4", leftSpan = 0, topSpan = 3, width = 2, height = 2)

                fabricModel.add(claim1).add(claim2).add(claim3).add(claim4)

                assertThat(fabricModel.countIntersected()).isEqualTo(12)
                assertThat(fabricModel.fabric).containsExactly(
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '#', '#', '.', '.', '.', '.', '.', '.'),
                    arrayOf('#', '#', '#', '#', '.', '.', '.', '.', '.', '.'),
                    arrayOf('X', 'X', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('X', 'X', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('#', '#', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('#', '#', 'X', 'X', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '#', '#', '#', '#', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.'),
                    arrayOf('.', '.', '.', '.', '.', '.', '.', '.', '.', '.')
                )
            }
        }

        describe("intact") {
            it("is intact") {
                val fabricModel = FabricModel(10)
                val claim1 = FabricClaim(id = "1", leftSpan = 2, topSpan = 3, width = 4, height = 5)
                val claim2 = FabricClaim(id = "2", leftSpan = 0, topSpan = 1, width = 4, height = 4)
                val claim3 = FabricClaim(id = "3", leftSpan = 8, topSpan = 1, width = 2, height = 2)

                fabricModel.add(claim1).add(claim2).add(claim3)

                assertThat(fabricModel.isIntact(claim1)).isFalse()
                assertThat(fabricModel.isIntact(claim2)).isFalse()
                assertThat(fabricModel.isIntact(claim3)).isTrue()
            }
        }
    }
})