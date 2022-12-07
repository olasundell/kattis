package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec3Test : AbstractKotlinTest() {
    private val s = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""

    @Test
    fun simple() {
        val result = Dec3().solve(Scanner(s))

        assertEquals("198", result)
    }

    @Test
    fun one() {
        runTest(1, Dec3()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec3().solve2(Scanner(s))

        assertEquals("230", result)
    }

    @Test
    fun filter3() {
        val dec3 = Dec3()
        val list = dec3.readList(Scanner(s))
        val result = dec3.filter3(list)
        assertEquals("10111", result)
    }

    @Test
    fun filterHi() {
        val dec3 = Dec3()
        val list = dec3.readList(Scanner(s))
        val result = dec3.filter(list)
        assertEquals("10111", result)
        assertEquals(23, result.toInt(2))
    }

    @Test
    fun filterLo() {
        val dec3 = Dec3()
        val list = dec3.readList(Scanner(s))
        val result = dec3.filter(list, false)
        assertEquals("01010", result)
        assertEquals(10, result.toInt(2))
    }

    @Test
    fun two() {
        runTest(1, Dec3()::solve2)
    }
}