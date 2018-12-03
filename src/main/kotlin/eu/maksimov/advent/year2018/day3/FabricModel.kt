package eu.maksimov.advent.year2018.day3

class FabricModel(size: Int) {

    companion object {
        const val EMPTY = '.'
        const val OK = '#'
        const val NOK = 'X'
    }

    val fabric: Array<Array<Char>> = Array(size) { Array(size) { EMPTY } }

    fun add(claim: FabricClaim): FabricModel {
        for (i in claim.topSpan..(claim.topSpan + claim.height - 1)) {
            for (j in claim.leftSpan..(claim.leftSpan + claim.width - 1)) {
                fabric[i][j] = if (fabric[i][j] == EMPTY) OK else NOK
            }
        }
        return this
    }

    fun countIntersected(): Int {
        return fabric.map { row -> row.count { it == NOK } }.sum()
    }

    fun isIntact(claim: FabricClaim): Boolean {
        for (i in claim.topSpan..(claim.topSpan + claim.height - 1)) {
            for (j in claim.leftSpan..(claim.leftSpan + claim.width - 1)) {
                if (fabric[i][j] == NOK) {
                    return false
                }
            }
        }
        return true
    }

}