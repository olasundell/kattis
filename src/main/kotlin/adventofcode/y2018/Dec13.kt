package adventofcode.y2018;

import java.lang.IllegalArgumentException
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec13 {
    private val COLLIDED: State = State(setOf(), setOf(), listOf())

    fun solve(scanner: Scanner): String {
        val lines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }

        val state = initState(lines)
        var stateAt = state

        System.err.println("$stateAt\n")

        for (i in 0..1_000) {
            try {
                stateAt = iterateState(stateAt)
                System.err.println("$stateAt\n")
            } catch (e: CollisionException) {
                return e.toString()
            }
        }

        return "-1"
    }

    fun iterateState(state: State): State {
        var st = State(state.rectangles, state.intersections, state.carts.map { moveCart(it, state.intersections) })

        for (r in state.rectangles) {
            if (hasCollision(st)) {
                val pos = st.carts.map { it.cartPosDir.pos }
                val map = mutableMapOf<Point, Int>()
                pos.forEach { map.merge(it, 1) { t: Int, u: Int -> u + 1 } }

                val p = map.filter { entry -> entry.value > 1 }.entries.first()
                throw CollisionException(p.key)
            }
        }

        return st
    }

    class CollisionException(val p: Point) : Exception() {
        override fun toString(): String {
            return "(${p.x}, ${p.y})"
        }
    }

    fun stateAt(state: State, iteration: Int): State {
        var st = State(state.rectangles, state.intersections, state.carts.map { moveCart(it, state.intersections) })

        for (r in state.rectangles) {
            if (hasCollision(st)) {
                return COLLIDED
            }
        }

        return state
    }

    fun moveCart(cart: Cart, intersections: Set<Intersection> = setOf()): Cart {
        val nP = cart.move()
        var newCart = if (cart.rectangle.onEdge(nP.pos)) {
            cart.at(nP)
        } else {
            cart.at(cart.move(cart.cartPosDir.dir))
        }

        newCart = newCart.to(findNextCartDirection(newCart))

        val filter = intersections.filter { it.point == newCart.cartPosDir.pos }
        return if (filter.isNotEmpty()) {
            val intersecting = filter[0].rectangles.filterNot { it == newCart.rectangle }[0]
            newCart.nextIntersection(intersecting, cart.rectangle)
        } else {
            newCart
        }
    }

    private fun findNextCartDirection(cart: Cart): Direction {
        val dir: Direction = when (cart.cartPosDir.dir) {
            Direction.UP -> if (cart.isAtTop()) {
                if (cart.isLeftmost()) {
                    Direction.RIGHT
                } else {
                    Direction.LEFT
                }
            } else {
//                Direction.NONE
                Direction.UP
            }

            Direction.DOWN -> if (cart.isAtBottom()) {
                if (cart.isLeftmost()) {
                    Direction.RIGHT
                } else {
                    Direction.LEFT
                }
            } else {
//                Direction.NONE
                Direction.DOWN
            }

            Direction.LEFT -> if (cart.isLeftmost()) {
                if (cart.isAtBottom()) {
                    Direction.UP
                } else {
                    Direction.DOWN
                }
            } else {
//                Direction.NONE
                Direction.LEFT
            }

            Direction.RIGHT -> if (cart.isRightmost()) {
                if (cart.isAtBottom()) {
                    Direction.UP
                } else {
                    Direction.DOWN
                }
            } else {
//                Direction.NONE
                Direction.RIGHT
            }

            else -> cart.cartPosDir.dir
        }
        return dir
    }

    fun hasCollision(state: State) = state.carts.map { it.cartPosDir.pos }.toSet().size != state.carts.size

    private fun initState(lines: MutableList<String>): State {
        var state: State = State(setOf(), setOf(), listOf())
        for (y in 0 until lines.size) {
            val currentLine = lines[y]
            for (x in currentLine.indices) {
                if (currentLine[x] == '/') {
                    val currentCarts = mutableSetOf<CartPosDir>()
                    if (isLeftSideOfRectangle(currentLine, x)) {
                        // trace right
                        var endX = 0
                        for (i in x + 1 until currentLine.length) {
                            if (currentLine[i] == '\\') {
                                endX = i
                                break
                            }
                            val dir = Direction.of(currentLine[i])
                            if (dir != Direction.NONE) {
                                currentCarts.add(CartPosDir(Point(i, y), dir))
                            }
                        }

                        // trace down
                        var endY = 0

                        for (i in y + 1 until lines.size) {
                            val dir = Direction.of(lines[i][x])
                            if (dir != Direction.NONE) {
                                currentCarts.add(CartPosDir(Point(x, i), dir))
                            }

                            val dir2 = Direction.of(lines[i][endX])
                            if (dir2 != Direction.NONE) {
                                currentCarts.add(CartPosDir(Point(endX, i), dir2))
                            }

                            if (lines[i][x] == '\\') {
                                endY = i
                                break
                            }
                        }

                        for (i in x..endX) {
                            val dir = Direction.of(lines[endY][i])
                            if (dir != Direction.NONE) {
                                currentCarts.add(CartPosDir(Point(i, endY), dir))
                            }
                        }

                        val rect = Rectangle(Point(x, y), Point(endX, endY))
                        state += rect
                        state += currentCarts.map { Cart(it, rect) }
                    }
                }
            }
        }

        for (y in 0 until lines.size) {
            for (x in lines[y].indices) {
                val point = Point(x, y)
                val found = state.rectangles.filter { it.onEdge(point) }
                if (found.size == 2) {
                    state = state.plus(Intersection(point, found.toSet()))
                }
            }
        }

        return state
    }

    private fun isLeftSideOfRectangle(currentLine: String, x: Int) = x == 0 ||
            currentLine[x - 1] == ' ' || currentLine[x - 1] == '\\' || currentLine[x - 1] == '|'

    data class Point(val x: Int, val y: Int) {
        operator fun plus(p: Point): Point = Point(this.x + p.x, this.y + p.y)
    }

    data class Rectangle(val upLeft: Point, val downRight: Point) {
        fun contains(point: Dec13.Point): Boolean {
            return (point.x >= upLeft.x && point.x <= downRight.x) && (point.y >= upLeft.y && point.y <= downRight.y)
        }

        fun onEdge(point: Dec13.Point): Boolean {
            return (point.x == upLeft.x || point.x == downRight.x) && upLeft.y.rangeTo(downRight.y).contains(point.y) ||
                    (point.y == upLeft.y || point.y == downRight.y) && upLeft.x.rangeTo(downRight.x).contains(point.x)
        }
    }

    data class CartPosDir(val pos: Point, val dir: Direction) {
        fun move(mightHaveTurned: Direction = Direction.NONE): CartPosDir {
            val turnedDir = when (mightHaveTurned) {
                Direction.LEFT -> this.dir.left()
                Direction.RIGHT -> this.dir.right()
                else -> this.dir
            }

            return CartPosDir(this.pos + Point(turnedDir.x, turnedDir.y), turnedDir)
        }
    }

    /**
     * it turns left the first time, goes straight the second time, turns right the third time
     */
    data class Cart(val cartPosDir: CartPosDir, val rectangle: Rectangle, val intersected: Int = 0) {
        fun at(pd: CartPosDir): Cart = Cart(pd, this.rectangle, this.intersected)
        fun at(pos: Point): Cart = Cart(CartPosDir(pos, this.cartPosDir.dir), this.rectangle, this.intersected)
        fun to(dir: Direction): Cart = Cart(CartPosDir(this.cartPosDir.pos, dir), this.rectangle, this.intersected)

        fun move(mightHaveTurned: Direction = Direction.NONE): CartPosDir {
            val turnedDir = when (mightHaveTurned) {
                Direction.LEFT -> cartPosDir.dir.left()
                Direction.RIGHT -> cartPosDir.dir.right()
                else -> cartPosDir.dir
            }

            return CartPosDir(this.cartPosDir.pos + Point(turnedDir.x, turnedDir.y), turnedDir)
        }

        fun nextIntersection(intersecting: Rectangle, oldRectangle: Rectangle): Cart {
            return when (intersected) {
                0 -> Cart(CartPosDir(this.cartPosDir.pos, this.cartPosDir.dir.left()), intersecting, (this.intersected + 1) % 3)
                1 -> Cart(this.cartPosDir, oldRectangle, (this.intersected + 1) % 3)
                2 -> Cart(CartPosDir(this.cartPosDir.pos, this.cartPosDir.dir.right()), intersecting, (this.intersected + 1) % 3)
                else -> throw IllegalArgumentException()
            }
        }

        fun isAtTop(): Boolean = rectangle.upLeft.y == cartPosDir.pos.y
        fun isLeftmost(): Boolean = rectangle.upLeft.x == cartPosDir.pos.x
        fun isAtBottom(): Boolean = rectangle.downRight.y == cartPosDir.pos.y
        fun isRightmost(): Boolean = rectangle.downRight.x == cartPosDir.pos.x
    }

    data class State(val rectangles: Set<Rectangle>, val intersections: Set<Intersection>, val carts: List<Cart>) {
        operator fun plus(rectangle: Rectangle): State = State(this.rectangles.plus(rectangle), this.intersections, this.carts)
        operator fun plus(intersection: Intersection): State = State(this.rectangles, this.intersections.plus(intersection), this.carts)
        operator fun plus(cart: Cart): State = State(this.rectangles, this.intersections, this.carts.plus(cart))
        operator fun plus(carts: Iterable<Cart>): State = State(this.rectangles, this.intersections, this.carts.plus(carts))

        override fun toString(): String {
            val maxX = rectangles.map { it.downRight.x }.maxOrNull()!!
            val minX = rectangles.map { it.upLeft.x }.minOrNull()!!

            val maxY = rectangles.map { it.downRight.y }.maxOrNull()!!
            val minY = rectangles.map { it.upLeft.y }.minOrNull()!!

            val rows = Array(maxY + 1) { CharArray(maxX + 1) { '.' } }

            rectangles.forEach {
                rows[it.upLeft.y][it.upLeft.x] = '/'
                rows[it.downRight.y][it.downRight.x] = '/'
                rows[it.upLeft.y][it.downRight.x] = '\\'
                rows[it.downRight.y][it.upLeft.x] = '\\'

                for (x in it.upLeft.x + 1 until it.downRight.x) {
                    rows[it.upLeft.y][x] = '-'
                    rows[it.downRight.y][x] = '-'
                }

                for (y in it.upLeft.y + 1 until it.downRight.y) {
                    rows[y][it.upLeft.x] = '|'
                    rows[y][it.downRight.x] = '|'
                }
            }

            intersections.forEach {
                rows[it.point.y][it.point.x] = '+'
            }

            carts.forEach {
                rows[it.cartPosDir.pos.y][it.cartPosDir.pos.x] = when (it.cartPosDir.dir) {
                    Direction.LEFT -> '<'
                    Direction.RIGHT -> '>'
                    Direction.DOWN -> 'v'
                    Direction.UP -> '^'
                    else -> 'X'
                }
            }

//            for (y in minY..maxY) {
//                val row = mutableListOf<Char>()
//                for (x in minX..maxX) {
//                    val p = Point(x, y)
//                    row.add(when (rectangles.filter { it.contains(p) }.size) {
//                        0 -> '.'
//                        1 -> '|'
//                        else -> '+'
//                    })
//                }
//
//                rows.add(row)
//            }

            return rows.joinToString(separator = "\n") { it.joinToString(separator = "") }
        }
    }

    data class Intersection(val point: Point, val rectangles: Set<Rectangle>)

    enum class Direction(val x: Int, val y: Int) {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1, 0),
        RIGHT(1, 0),
        NONE(0, 0);

        fun left() = when (this) {
            UP -> LEFT
            DOWN -> RIGHT
            LEFT -> DOWN
            RIGHT -> UP
            else -> NONE
        }

        fun right() = when (this) {
            UP -> RIGHT
            DOWN -> LEFT
            LEFT -> UP
            RIGHT -> DOWN
            else -> NONE
        }

        companion object {
            fun of(c: Char): Direction = when (c) {
                '>' -> RIGHT
                '<' -> LEFT
                '^' -> UP
                'v' -> DOWN
                else -> NONE
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec13().solve(scanner))
}