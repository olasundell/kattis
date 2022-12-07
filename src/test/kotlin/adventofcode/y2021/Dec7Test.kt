package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec7Test : AbstractKotlinTest() {
    val s = "16,1,2,0,4,2,7,1,2,14"

    @Test
    fun simple() {
        val result = Dec7().solve(Scanner(s))

        assertEquals("37", result)
    }

    @Test
    fun one() {
        runTest(1, Dec7()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec7().solve2(Scanner(s))

        assertEquals("168", result)
    }

    @Test
    fun two() {
        runTest(1, Dec7()::solve2)
    }
}