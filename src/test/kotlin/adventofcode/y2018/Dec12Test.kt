package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec12Test : AbstractKotlinTest() {
    @Test
    fun unitTest() {
        runTest(1, Dec12()::solve)
    }

    @Test
    fun first() {
        runTest(2, Dec12()::solve)
    }
}