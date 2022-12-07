package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec9Test : AbstractKotlinTest() {
    val input = """35
20
15
25
47
40
62
55
65
95
102
117
150
182
127
219
299
277
309
576"""

    @Test
    fun simple1() {
        val result = Dec9(5).solve(Scanner(input))
        assertEquals("127", result)
    }

    @Test
    fun one() {
        runTest(1, Dec9(25)::solve)
    }

    @Test
    fun simple2() {
        val result = Dec9(5).solve2(Scanner(input))
        assertEquals("62", result)
    }

    @Test
    fun two() {
        runTest(1, Dec9(25)::solve2)
    }
}