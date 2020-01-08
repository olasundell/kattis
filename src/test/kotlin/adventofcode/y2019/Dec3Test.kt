package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec3Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec3()::solve)
    }
}