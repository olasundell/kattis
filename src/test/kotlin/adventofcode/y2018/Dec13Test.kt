package adventofcode.y2018

import org.junit.Assert
import org.junit.Before
import util.AbstractKotlinTest

import org.junit.Test
import adventofcode.y2018.Dec13.*
import java.lang.System.out

/**
 * TODO write documentation
 */
class Dec13Test : AbstractKotlinTest() {
    lateinit var rectangle: Dec13.Rectangle
    lateinit var intersections: Set<Dec13.Intersection>

    @Before
    fun setup() {
        val upLeft = Point(1, 1)
        val downRight = Point(3, 4)

        rectangle = Rectangle(upLeft, downRight)
        intersections = setOf()
    }

    private fun move(cart: Cart, intersections: Set<Intersection>, iterations: Int): Cart {
        var result = cart
        for (i in 0 until iterations) {
            result = Dec13().moveCart(result, intersections)
        }

        return result
    }

    @Test
    fun unitOne() {
        runTest(1, Dec13()::solve)
    }

    @Test
    fun unitTwo() {
        runTest(2, Dec13()::solve)
    }

    @Test
    fun unitThree() {
        runTest(3, Dec13()::solve)
    }

    @Test
    fun unitFour() {
        runTest(4, Dec13()::solve)
    }

    @Test
    fun unitFive() {
        runTest(5, Dec13()::solve)
    }

    @Test
    fun unitSix() {
        runTest(6, Dec13()::solve)
    }

    @Test
    fun moveRightOnceTest() {
        val cart = Cart(CartPosDir(Point(2, 1), Direction.RIGHT), rectangle)
        val moveCart = Dec13().moveCart(cart, intersections)

        Assert.assertEquals(CartPosDir(Point(3, 1), Direction.RIGHT), moveCart.cartPosDir)
    }

    @Test
    fun moveRightThroughUpperCornerTest() {
        val cart = Cart(CartPosDir(Point(2, 1), Direction.RIGHT), rectangle)

        val moveCart = move(cart, intersections, 2)

        Assert.assertEquals(CartPosDir(Point(3, 2), Direction.DOWN), moveCart.cartPosDir)
    }

    @Test
    fun moveLeftThroughUpperCornerTest() {
        val cart = Cart(CartPosDir(Point(2, 1), Direction.LEFT), rectangle)

        val moveCart = move(cart, intersections, 2)

        Assert.assertEquals(CartPosDir(Point(1, 2), Direction.DOWN), moveCart.cartPosDir)
    }

    @Test
    fun moveUpThroughUpperCornerTest() {
        val cart = Cart(CartPosDir(Point(1, 2), Direction.UP), rectangle)

        val moveCart = move(cart, intersections, 2)

        Assert.assertEquals(CartPosDir(Point(2, 1), Direction.RIGHT), moveCart.cartPosDir)
    }

    @Test
    fun moveDownThroughLowerCornerTest() {
        val cart = Cart(CartPosDir(Point(3, 3), Direction.DOWN), rectangle)

        val moveCart = move(cart, intersections, 2)

        Assert.assertEquals(CartPosDir(Point(2, 4), Direction.LEFT), moveCart.cartPosDir)
    }

    @Test
    fun shouldTurnAtIntersections() {
        val cart = Cart(CartPosDir(Point(3, 2), Direction.DOWN), rectangle)

        val intersectRect = Rectangle(Point(2, 3), Point(5, 5))

        val rectangles = setOf(rectangle, intersectRect)
        val intersections1 = setOf(Intersection(Point(3, 3), rectangles), Intersection(Point(2,4), rectangles))

        val state = State(rectangles, intersections1, listOf(cart))

        val moveCart = move(cart, intersections1, 1)

        Assert.assertEquals(CartPosDir(Point(3, 3), Direction.RIGHT), moveCart.cartPosDir)
        Assert.assertEquals(intersectRect, moveCart.rectangle)

        val mc2 = move(moveCart, intersections1, 1)
        Assert.assertEquals(CartPosDir(Point(4, 3), Direction.RIGHT), mc2.cartPosDir)
        Assert.assertEquals(intersectRect, mc2.rectangle)
    }

    @Test
    fun shouldNotHaveCollision() {
        val cart1 = Cart(CartPosDir(Point(3, 3), Direction.DOWN), rectangle)
        val cart2 = Cart(CartPosDir(Point(4, 3), Direction.DOWN), rectangle)

        val state = State(setOf(rectangle), setOf(), listOf(cart1, cart2))

        Assert.assertFalse(Dec13().hasCollision(state))
    }

    @Test
    fun shouldHaveCollision() {
        val cart1 = Cart(CartPosDir(Point(3, 3), Direction.DOWN), rectangle)
        val cart2 = Cart(CartPosDir(Point(3, 3), Direction.DOWN), rectangle)

        val state = State(setOf(rectangle), setOf(), listOf(cart1, cart2))

        Assert.assertTrue(Dec13().hasCollision(state))
    }

    @Test
    fun shouldHaveCollisionAfterMove() {

    }
}