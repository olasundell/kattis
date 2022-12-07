package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CircuitMathTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CircuitMath()::solve)
    }

    @Test
    fun two() {
        runTest(2, CircuitMath()::solve)
    }

    @Test
    fun three() {
        runTest(3, CircuitMath()::solve)
    }

    @Test
    fun four() {
        runTest(4, CircuitMath()::solve)
    }
}