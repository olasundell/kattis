package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec13Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec13()::solveFirst)
    }

    @Test
    fun two() {
        runTest(2, Dec13()::solveSecond)
    }
}