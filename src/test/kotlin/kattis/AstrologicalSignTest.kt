package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class AstrologicalSignTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, AstrologicalSign()::solve)
    }

    @Test
    fun two() {
        runTest(2, AstrologicalSign()::solve)
    }

    @Test
    fun three() {
        runTest(3, AstrologicalSign()::solve)
    }

    @Test
    fun four() {
        runTest(4, AstrologicalSign()::solve)
    }

    @Test
    fun five() {
        runTest(5, AstrologicalSign()::solve)
    }
}