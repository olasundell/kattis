package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class DigitSwapTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, DigitSwap()::solve)
    }

    @Test
    fun two() {
        runTest(2, DigitSwap()::solve)
    }
}