package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec6Test : AbstractKotlinTest() {
    @Test
    fun simple() {
        val input = """abc

a
b
c

ab
ac

a
a
a
a

b

"""

        val result = Dec6().solve(Scanner(input))

        assertEquals("11", result)
    }

    @Test
    fun one() {
        runTest(1, Dec6()::solve)
    }

    @Test
    fun simple2() {
        val input = """abc

a
b
c

ab
ac

a
a
a
a

b

"""

        val result = Dec6().solve2(Scanner(input))

        assertEquals("6", result)
    }

    @Test
    fun two() {
        runTest(1, Dec6()::solve2)
    }
}