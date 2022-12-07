package adventofcode.y2020

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
        val s = """1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc""".trimIndent()

        val result = Dec2().solve(Scanner(s))

        assertEquals("2", result)
    }

    @Test
    fun one() {
        runTest(1, Dec2()::solve)
    }

    @Test
    fun simpleTwo() {
        val s = """1-3 a: abcde
1-3 b: cdefg
2-9 c: ccccccccc""".trimIndent()

        val result = Dec2().solve2(Scanner(s))

        assertEquals("1", result)

    }

    @Test
    fun two() {
        runTest(1, Dec2()::solve2)
    }
}