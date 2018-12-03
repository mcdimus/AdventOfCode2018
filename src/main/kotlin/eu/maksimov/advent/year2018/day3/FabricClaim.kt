package eu.maksimov.advent.year2018.day3

data class FabricClaim(
    val id: String,
    val leftSpan: Int,
    val topSpan: Int,
    val width: Int,
    val height: Int
) {

    companion object {
        private val regex = Regex("#(?<id>\\d+) @ (?<lspan>\\d+),(?<tspan>\\d+): (?<width>\\d+)x(?<height>\\d+)")

        fun of(claimSpec: String): FabricClaim {
            val matchGroups = regex.find(claimSpec)?.groups
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")

            val id = matchGroups["id"]?.value
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")
            val leftSpan = matchGroups["lspan"]?.value?.toInt()
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")
            val topSpan = matchGroups["tspan"]?.value?.toInt()
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")
            val width = matchGroups["width"]?.value?.toInt()
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")
            val height = matchGroups["height"]?.value?.toInt()
                ?: throw IllegalArgumentException("Invalid claim spec: $claimSpec")

            return FabricClaim(id, leftSpan, topSpan, width, height)
        }
    }

}