package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class Dec20Test : AbstractKotlinTest() {
    @Test
    fun simple1() {
        runTest(2, Dec20()::solve)
    }
}