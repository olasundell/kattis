package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec6Test : AbstractKotlinTest() {
    val s = """3,4,3,1,2"""

    @Test
    fun simple() {
        val result = Dec6(18).solve2(Scanner(s))

        assertEquals("26", result)

        val result2 = Dec6(80).solve2(Scanner(s))

        assertEquals("5934", result2)
    }

    @Test
    fun one() {
        runTest(1, Dec6(80)::solve2)
    }

    @Test
    fun simple2() {
        val result2 = Dec6(256).solve2(Scanner(s))

        assertEquals("26984457539", result2)
    }

    @Test
    fun two() {
        runTest(1, Dec6(256)::solve2)
    }
}