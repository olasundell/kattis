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

    fun moveCart(cart: Cart, rectangle: Rectangle, iteration: Int, intersections: Set<Intersection> = setOf()): Cart {
        var currentCart = cart
        for (i in 0 until iteration) {
            val nP = currentCart.move()
            currentCart = if (rectangle.contains(nP)) {
                Cart(nP, currentCart.direction)
            } else {
                val dir = when (currentCart.direction) {
                    Direction.UP, Direction.DOWN -> if (currentCart.cartPos.x == rectangle.upLeft.x) Direction.RIGHT else Direction.LEFT
                    Direction.LEFT, Direction.RIGHT -> if (currentCart.cartPos.y == rectangle.upLeft.y) Direction.DOWN else Direction.UP
                    else -> Direction.NONE
                }

                Cart(Cart(currentCart.cartPos, dir).move(), dir)
            }
        }

        return currentCart
    }

    fun hasCollision(state: State) = state.carts.map { it.cartPos }.toSet().size != state.carts.size

    private fun initState(lines: MutableList<String>): State {
        var state: State = State(setOf(), setOf(), listOf())
        for (y in 0 until lines.size) {
            val currentLine = lines[y]
            for (x in 0 until currentLine.length) {
                if (currentLine[x] == '/') {
                    if (isLeftSideOfRectangle(currentLine, x)) {
                        // trace
//                        var cart: Cart = Cart(Point(-1, -1), Direction.NONE)
                        var endX = 0
                        for (i in x + 1 until currentLine.length) {
                            if (currentLine[i] == '\\') {
                                endX = i
                            }
                            when (currentLine[i]) {
                                '>' -> state = state.plus(Cart(Point(i, y), Direction.RIGHT))
                                '<' -> state = state.plus(Cart(Point(i, y), Direction.LEFT))
                            }
                        }

                        var endY = 0

                        for (i in y + 1 until lines.size) {
                            when (lines[i][x]) {
                                '^' -> state = state.plus(Cart(Point(x, i), Direction.UP))
                                'v' -> state = state.plus(Cart(Point(x, i), Direction.DOWN))
                            }
                            when (lines[i][endX]) {
                                '^' -> state = state.plus(Cart(Point(endX, i), Direction.UP))
                                'v' -> state = state.plus(Cart(Point(endX, i), Direction.DOWN))
                            }

                            if (lines[i][x] == '\\') {
                                endY = i
                                break
                            }
                        }
                        val rect = Rectangle(Point(x, y), Point(endX, endY))
                        state = state.plus(rect)
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

    /**
     * it turns left the first time, goes straight the second time, turns right the third time
     */
    data class Cart(val cartPos: Point, val direction: Direction, val intersected: Int = 0) {
        fun move(mightHaveTurned: Direction = Direction.NONE): Point {
            val turnedDir = when (mightHaveTurned) {
                Direction.LEFT -> direction.left()
                Direction.RIGHT -> direction.right()
                else -> direction
            }

            return cartPos + Point(turnedDir.x, turnedDir.y)
        }

        fun nextIntersection(): Point {
            return when (intersected) {
                0 -> move(Direction.LEFT)
                1 -> move(Direction.NONE)
                2 -> move(Direction.RIGHT)
                else -> throw IllegalArgumentException()
            }
        }
    }

    data class State(val rectangles: Set<Rectangle>, val intersections: Set<Intersection>, val carts: List<Cart>) {
        operator fun plus(rectangle: Rectangle): State = State(this.rectangles.plus(rectangle), this.intersections, this.carts)
        operator fun plus(intersection: Intersection): State = State(this.rectangles, this.intersections.plus(intersection), this.carts)
        operator fun plus(cart: Cart): State = State(this.rectangles, this.intersections, this.carts.plus(cart))
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
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec13().solve(scanner))
}