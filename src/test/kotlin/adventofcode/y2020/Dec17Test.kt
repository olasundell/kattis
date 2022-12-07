package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec17Test : AbstractKotlinTest() {
    @Test
    fun simple1() {
        val input = """.#.
..#
###"""
        val actual = Dec17().solve(Scanner(input))

        assertEquals("112", actual)
    }
}