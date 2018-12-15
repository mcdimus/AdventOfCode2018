package eu.maksimov.advent.year2018.day13

class Rails(lines: List<String>) {

    private val maxLength: Int = lines.map { it.length }.max()!!
    private val map = Array(lines.size) { Array(maxLength) { ' ' } }
    var carts = mutableListOf<Cart>()

    init {
        for (y in 0 until lines.size) {
            for (x in 0 until maxLength) {
                map[y][x] = lines[y].getOrNull(x) ?: ' '
                CartFaceDirection.of(map[y][x])?.let {
                    carts.add(Cart(faceDirection = it, x = x, y = y))
                }
            }
        }
    }

    fun tick() {
        for (cart in carts) {
            cart.move(map)
            if (carts.filter { it !== cart }.any { other -> cart.y == other.y && cart.x == other.x })
                throw CollisionException(cart)
        }
        carts.sort()
    }

    fun tickWithCollisionPrediction() {
        val cartsToMove = carts.toMutableList()
        while (cartsToMove.isNotEmpty()) {
            val movedCart = cartsToMove.removeAt(0)
            movedCart.move(map)
            if (carts.filter { it !== movedCart }.any { cart -> movedCart.y == cart.y && movedCart.x == cart.x }) {
                carts = carts.filterNot { cart -> cart.y == movedCart.y && cart.x == movedCart.x }.toMutableList()
                cartsToMove.removeIf { cart -> cart.y == movedCart.y && cart.x == movedCart.x }
            }
        }
        carts.sort()
    }

}