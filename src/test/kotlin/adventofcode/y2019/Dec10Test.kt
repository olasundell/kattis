package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test
import java.awt.Point

/**
 * TODO write documentation
 */
class Dec10Test : AbstractKotlinTest() {
    @Test
    fun `direction should compare properly`() {
        val origin = Point(5,5)

        val up = Point(5,1)
        val upRight = Point(7, 2)
        val upLeft = Point(3,3)
        val left = Point(2, 5)
        val right = Point(8,5)
        val down = Point(5,9)
        val downRight = Point(8,8)
        val downLeft = Point(2,7)

//        val list = listOf(downLeft, downRight, down, left, right, upLeft, upRight, up).map { Dec10.Direction(origin, it) }
//        val sorted = list.sorted()
//
//        assertEquals(up, list[0].p)
    }

    @Test
    fun one() {
        val dec10 = Dec10()
        runTest(1, dec10::solve)

        dec10.revKMap
    }

    @Test
    fun two() {
        runTest(2, Dec10()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec10()::solve)
    }

    @Test
    fun four() {
        runTest(4, Dec10()::solve)
    }

    @Test
    fun five() {
        runTest(5, Dec10()::solve)
    }

}