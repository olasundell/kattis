package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec2Test : AbstractKotlinTest() {
    @Test
    fun simple() {
        val s = """forward 5
down 5
forward 8
up 3
down 8
forward 2"""

        val result = Dec2().solve(Scanner(s))

        assertEquals("150", result)
    }

    @Test
    fun one() {
        runTest(1, Dec2()::solve)
    }

    @Test
    fun simple2() {
        val s = """forward 5
down 5
forward 8
up 3
down 8
forward 2"""

        val result = Dec2().solve2(Scanner(s))

        assertEquals("900", result)

    }

    @Test
    fun two() {
        runTest(1, Dec2()::solve2)
    }
}