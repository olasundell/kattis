package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec9Test : AbstractKotlinTest() {
    val s = """2199943210
3987894921
9856789892
8767896789
9899965678"""

    @Test
    fun simple() {
        val result = Dec9().solve(Scanner(s))

        assertEquals("15", result)
    }

    @Test
    fun one() {
        runTest(1, Dec9()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec9().solve2(Scanner(s))

        assertEquals("1134", result)
    }

    @Test
    fun two() {
        runTest(1, Dec9()::solve2)
    }
}