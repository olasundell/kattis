package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.awt.Point

/**
 * TODO write documentation
 */
class Dec10DirectionTest : AbstractKotlinTest() {
    private val origin = Point(5,5)

    val up = Point(5,1)
    val upRight = Point(7, 2)
    val upLeft = Point(3,3)
    val left = Point(2, 5)
    val right = Point(8,5)
    val down = Point(5,9)
    val downRight = Point(8,8)
    val downLeft = Point(2,7)

    val map = listOf(downLeft, downRight, down, left, right, upLeft, upRight, up).map { it to Dec10.Direction(origin, it) }.toMap()
    val sorted = map.values.sorted()

    @Test
    fun `down left should be after right`() {
        val dl = map[downLeft]!!
        val r = map[right]!!
        kotlin.test.assertTrue(dl > r)
        kotlin.test.assertTrue(r < dl)
    }

    @Test
    fun `down left should be after down`() {
        val dl = map[downLeft]!!
        val d = map[down]!!
        kotlin.test.assertTrue(d < dl, "down should be less than down left")
        kotlin.test.assertTrue(dl > d, "down left should be greater than down")
    }

    @Test
    fun `direction should compare properly`() {

        val correctList = listOf(up, upRight, right, downRight, down, downLeft, left, upLeft).map { map[it]!! }

        assertEquals(correctList.map { it.p }, sorted.map { it.p })
    }

    @Test
    fun `should behave properly when put in a set`() {
        val set = setOf(Dec10.Direction(origin, Point(6, 6)), Dec10.Direction(origin, Point(7, 7)))
    }
}