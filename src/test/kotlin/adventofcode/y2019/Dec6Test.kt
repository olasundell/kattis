package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec6Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec6()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec6()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec6()::solve)
    }
}