package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec5Test : AbstractKotlinTest() {
    val s = """0,9 -> 5,9
8,0 -> 0,8
9,4 -> 3,4
2,2 -> 2,1
7,0 -> 7,4
6,4 -> 2,0
0,9 -> 2,9
3,4 -> 1,4
0,0 -> 8,8
5,5 -> 8,2"""

    @Test
    fun simple() {
        val result = Dec5().solve(Scanner(s))

        assertEquals("5", result)
    }

    @Test
    fun one() {
        runTest(1, Dec5()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec5(true).solve(Scanner(s))

        assertEquals("12", result)
    }

    @Test
    fun two() {
        runTest(1, Dec5(true)::solve)
    }
}