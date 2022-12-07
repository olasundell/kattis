package adventofcode.y2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec1Test : AbstractKotlinTest() {
    @Test
    fun simple() {
        val s = """199
200
208
210
200
207
240
269
260
263""".trimIndent()

        val result = Dec1().solve(Scanner(s))

        assertEquals("7", result)
    }

    @Test
    fun simple2() {
        val s = """199
200
208
210
200
207
240
269
260
263""".trimIndent()

        val result = Dec1(3).solve(Scanner(s))

        assertEquals("5", result)
    }

    @Test
    fun one() {
        runTest(1, Dec1()::solve)
    }


    @Test
    fun two() {
        runTest(1, Dec1(3)::solve)
    }
}