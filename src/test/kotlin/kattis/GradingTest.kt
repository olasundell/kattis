package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class GradingTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Grading()::solve)
    }

    @Test
    fun two() {
        runTest(2, Grading()::solve)
    }

    @Test
    fun three() {
        runTest(3, Grading()::solve)
    }
}