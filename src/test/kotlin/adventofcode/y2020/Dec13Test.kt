package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec13Test : AbstractKotlinTest() {
    @Test
    fun foo() {
        for (i in 7 until 1_000 step 7) {
            if ((i + 1) % 13 == 0) {
                println("$i ${i / 7} ${(i + 1) / 13}")
            }
        }
    }
    val simpleInput = """939
7,13,x,x,59,x,31,19"""

    @Test
    fun simple1() {
        val actual = Dec13().solve(Scanner(simpleInput))

        assertEquals("295", actual)
    }

    @Test
    fun simple2() {
        val actual = Dec13().solve2(Scanner(simpleInput))

        assertEquals("1068781", actual)
    }

    @Test
    fun two() {
        val input = """1002632
23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,829,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,677,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19"""

        val actual = Dec13().solve2(Scanner(input))

        assertEquals("1", actual)
    }

    @Test
    fun one() {
        val input = """1002632
23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,829,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,677,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19"""

        val actual = Dec13().solve(Scanner(input))

        assertEquals("1", actual)
    }
}