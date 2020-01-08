package adventofcode.y2019

import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec1Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec1()::solve)
    }

    @Test
    fun calcShouldBeCorrect() {
        assertEquals(966, Dec1().calc(1969))
        assertEquals(50346, Dec1().calc(100756))
    }
}