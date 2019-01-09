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

        for (i in 0..1_000) {
            if (hasCollision(stateAt(state, i))) {
                System.out.println("Collision at $i")
                return "$i"
            }
        }

        return "-1"
    }

    fun stateAt(state: State, iteration: Int): State {
        var st = state
        for (cart in state.carts) {

        }
        for (r in state.rectangles) {
            if (hasCollision(st)) {
                return COLLIDED
            }
        }
//        return State(state.rectangles.map { moveCart(it, iteration) }.toSet(), state.intersections)
        return state
    }

    fun moveCart(cart: Cart, intersections: Set<Intersection> = setOf()): Cart {
        val nP = cart.move()
        return if (cart.rectangle.contains(nP.pos)) {
            cart.at(nP)
        } else {
//            val dir = when (cart.cartPosDir.dir) {
//
//                Direction.UP, Direction.DOWN -> if (cart.cartPosDir.pos.x == cart.rectangle.upLeft.x) Direction.RIGHT else Direction.LEFT
//                Direction.LEFT, Direction.RIGHT -> if (cart.cartPosDir.pos.y == cart.rectangle.upLeft.y) Direction.DOWN else Direction.UP
//                else -> Direction.NONE
//            }

            val dir: Direction = when (cart.cartPosDir.dir) {
                Direction.UP -> if (cart.isAtTop()) {
                    if (cart.isLeftmost()) {
                        Direction.RIGHT
                    } else {
                        Direction.LEFT
                    }
                } else {
                    Direction.NONE
                }

                Direction.DOWN -> if (cart.isAtBottom()) {
                    if (cart.isLeftmost()) {
                        Direction.LEFT
                    } else {
                        Direction.RIGHT
                    }
                } else {
                    Direction.NONE
                }

                Direction.LEFT -> if (cart.isLeftmost()) {
                    if (cart.isAtBottom()) {
                        Direction.RIGHT
                    } else {
                        Direction.LEFT
                    }
                } else {
                    Direction.NONE
                }

                Direction.RIGHT -> if (cart.isRightmost()) {
                    if (cart.isAtBottom()) {
                        Direction.LEFT
                    } else {
                        Direction.RIGHT
                    }
                } else {
                    Direction.NONE
                }

                else -> cart.cartPosDir.dir
            }

            cart.at(cart.move(dir))
        }
    }

    fun hasCollision(state: State) = state.carts.map { it.cartPosDir.pos }.toSet().size != state.carts.size

    private fun initState(lines: MutableList<String>): State {
        var state: State = State(setOf(), setOf(), listOf())
        for (y in 0 until lines.size) {
            val currentLine = lines[y]
            for (x in 0 until currentLine.length) {
                if (currentLine[x] == '/') {
                    var currentCarts = setOf<CartPosDir>()
                    if (isLeftSideOfRectangle(currentLine, x)) {
                        var endX = 0
                        for (i in x + 1 until currentLine.length) {
                            if (currentLine[i] == '\\') {
                                endX = i
                            }
                            val dir = Direction.of(currentLine[i])
                            if (dir != Direction.NONE) {
                                currentCarts = currentCarts.plus(CartPosDir(Point(i, y), dir))
                            }
                        }

                        var endY = 0

                        for (i in y + 1 until lines.size) {
                            val dir = Direction.of(currentLine[i])
                            if (dir != Direction.NONE) {
                                currentCarts = currentCarts.plus(CartPosDir(Point(i, y), dir))
                            }

                            val dir2 = Direction.of(currentLine[endX])
                            if (dir2 != Direction.NONE) {
                                currentCarts = currentCarts.plus(CartPosDir(Point(i, y), dir))
                            }

                            if (lines[i][x] == '\\') {
                                endY = i
                                break
                            }
                        }
                        val rect = Rectangle(Point(x, y), Point(endX, endY))
                        state += rect
                        state += currentCarts.map { Cart(it, rect) }
                    }
                }
            }
        }

        return state
    }

    private fun isLeftSideOfRectangle(currentLine: String, x: Int) = x == 0 || currentLine[x - 1] != '-'

    data class Point(val x: Int, val y: Int) {
        operator fun plus(p: Point): Point = Point(this.x + p.x, this.y + p.y)
    }

    data class Rectangle(val upLeft: Point, val downRight: Point) {
        fun contains(point: Dec13.Point): Boolean {
            return (point.x >= upLeft.x && point.x <= downRight.x) && (point.y >= upLeft.y && point.y <= downRight.y)
        }
    }

    data class CartPosDir(val pos: Point, val dir: Direction)

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

        fun nextIntersection(): CartPosDir {
            return when (intersected) {
                0 -> move(Direction.LEFT)
                1 -> move(Direction.NONE)
                2 -> move(Direction.RIGHT)
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
    }

    data class Intersection(val point: Point, val rectangles: Set<Rectangle>)

    enum class Direction(val x: Int, val y: Int) {
        UP(0, -1),
        DOWN(0, 1),
        LEFT(-1 ,0),
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