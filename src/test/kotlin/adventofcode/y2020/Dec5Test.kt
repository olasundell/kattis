package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class Dec5Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec5()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec5()::solve2)
    }
}