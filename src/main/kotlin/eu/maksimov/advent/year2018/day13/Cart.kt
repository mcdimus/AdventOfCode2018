package eu.maksimov.advent.year2018.day13

data class Cart(var faceDirection: CartFaceDirection, var x: Int, var y: Int) : Comparable<Cart> {

    private var nextIntersectionStrategy = IntersectionStrategy.TURN_LEFT

    fun move(map: Array<Array<Char>>) {
        when (faceDirection) {
            CartFaceDirection.LEFT -> moveLeft(map)
            CartFaceDirection.RIGHT -> moveRight(map)
            CartFaceDirection.UP -> moveUp(map)
            CartFaceDirection.DOWN -> moveDown(map)
        }
    }

    private fun moveLeft(map: Array<Array<Char>>) {
        val destinationChar = map[y][x - 1]
        x -= 1
        faceDirection = faceDirection.turn(destinationChar, nextIntersectionStrategy)
        if (destinationChar == '+') {
            nextIntersectionStrategy = nextIntersectionStrategy.next
        }
    }

    private fun moveRight(map: Array<Array<Char>>) {
        val destinationChar = map[y][x + 1]
        x += 1
        faceDirection = faceDirection.turn(destinationChar, nextIntersectionStrategy)
        if (destinationChar == '+') {
            nextIntersectionStrategy = nextIntersectionStrategy.next
        }
    }

    private fun moveUp(map: Array<Array<Char>>) {
        val destinationChar = map[y - 1][x]
        y -= 1
        faceDirection = faceDirection.turn(destinationChar, nextIntersectionStrategy)
        if (destinationChar == '+') {
            nextIntersectionStrategy = nextIntersectionStrategy.next
        }
    }

    private fun moveDown(map: Array<Array<Char>>) {
        val destinationChar = map[y + 1][x]
        y += 1
        faceDirection = faceDirection.turn(destinationChar, nextIntersectionStrategy)
        if (destinationChar == '+') {
            nextIntersectionStrategy = nextIntersectionStrategy.next
        }
    }

    override fun compareTo(other: Cart): Int =
        if (this.y == other.y) {
            this.x - other.x
        } else {
            this.y - other.y
        }

}