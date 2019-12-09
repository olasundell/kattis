import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test
import CountingStars.*
import kotlin.test.assertTrue

/**
 * TODO write documentation
 */
class CountingStarsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CountingStars()::solve)
    }

    @Test
    fun two() {
        runTest(2, CountingStars()::solve)
    }

    @Test
    fun surroundedByShouldWork() {
        val set = setOf(Point(0, 0), Point(0, 1))
        assertEquals(setOf(Point(0, 1)), set.neighbours(Point(0, 2)))
        assertEquals(setOf<Point>(), set.neighbours(Point(1, 2)))
    }

    fun Set<Point>.neighbours(p: Point): Set<Point> = this.filter { it in p.neighs() }.toSet()
}
