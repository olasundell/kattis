package adventofcode.y2019

import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

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
        Assert.assertEquals(966, Dec1().calc(1969))
        Assert.assertEquals(50346, Dec1().calc(100756))
    }
}