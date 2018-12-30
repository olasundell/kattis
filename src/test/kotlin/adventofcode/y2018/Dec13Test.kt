package adventofcode.y2018

import org.junit.Assert
import org.junit.Before
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class Dec13Test : AbstractKotlinTest() {
    lateinit var rectangle: Dec13.Rectangle

//    @Test
    fun unitOne() {
        runTest(1, Dec13()::solve)
    }

    @Test
    fun moveRightOnceTest() {
        val cart = Dec13.Cart(Dec13.Point(2, 1), Dec13.Direction.RIGHT)
        val moveCart = Dec13().moveCart(cart, rectangle, 1)

        Assert.assertEquals(Dec13.Point(3, 1), moveCart.cartPos)
    }

    @Test
    fun moveRightThroughUpperCornerTest() {
        val cart = Dec13.Cart(Dec13.Point(2, 1), Dec13.Direction.RIGHT)
        val moveCart = Dec13().moveCart(cart, rectangle, 2)

        Assert.assertEquals(Dec13.Point(3, 2), moveCart.cartPos)
    }

    @Test
    fun moveLeftThroughUpperCornerTest() {
        val cart = Dec13.Cart(Dec13.Point(2, 1), Dec13.Direction.LEFT)

        val moveCart = Dec13().moveCart(cart, rectangle, 2)

        Assert.assertEquals(Dec13.Point(1, 2), moveCart.cartPos)
    }

    @Test
    fun moveUpThroughUpperCornerTest() {
        val cart = Dec13.Cart(Dec13.Point(1, 2), Dec13.Direction.UP)

        val moveCart = Dec13().moveCart(cart, rectangle, 2)

        Assert.assertEquals(Dec13.Point(2, 1), moveCart.cartPos)
    }

    @Test
    fun moveDownThroughLowerCornerTest() {
        val cart = Dec13.Cart(Dec13.Point(3, 3), Dec13.Direction.DOWN)

        val moveCart = Dec13().moveCart(cart, rectangle, 2)

        Assert.assertEquals(Dec13.Point(2, 4), moveCart.cartPos)
    }

    @Test
    fun shouldTurnAtIntersections() {
        val cart = Dec13.Cart(Dec13.Point(3, 2), Dec13.Direction.DOWN)

        val intersectRect = Dec13.Rectangle(Dec13.Point(2, 3), Dec13.Point(5, 5))
        val moveCart = Dec13().moveCart(cart, rectangle, 2, setOf(Dec13.Intersection(Dec13.Point(3, 3), setOf(intersectRect, rectangle))))
        Assert.assertEquals(Dec13.Point(4, 3), moveCart.cartPos)
    }

    @Test
    fun shouldNotHaveCollision() {
        val cart1 = Dec13.Cart(Dec13.Point(3, 3), Dec13.Direction.DOWN)
        val cart2 = Dec13.Cart(Dec13.Point(4, 3), Dec13.Direction.DOWN)

        val state = Dec13.State(setOf(rectangle), setOf(), listOf(cart1, cart2))

        Assert.assertFalse(Dec13().hasCollision(state))
    }

    @Test
    fun shouldHaveCollision() {
        val cart1 = Dec13.Cart(Dec13.Point(3, 3), Dec13.Direction.DOWN)
        val cart2 = Dec13.Cart(Dec13.Point(3, 3), Dec13.Direction.DOWN)

        val state = Dec13.State(setOf(rectangle), setOf(), listOf(cart1, cart2))

        Assert.assertTrue(Dec13().hasCollision(state))
    }

    @Test
    fun shouldHaveCorrectStateAt() {
        val cart = Dec13.Cart(Dec13.Point(2, 1), Dec13.Direction.RIGHT)
//        Dec13().stateAt
    }

    @Before
    fun setup() {
        val upLeft = Dec13.Point(1, 1)
        val downRight = Dec13.Point(3, 4)

        rectangle = Dec13.Rectangle(upLeft, downRight)
    }

}