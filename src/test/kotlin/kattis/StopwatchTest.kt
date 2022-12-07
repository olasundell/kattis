package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class StopwatchTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Stopwatch()::solve)
    }

    @Test
    fun two() {
        runTest(2, Stopwatch()::solve)
    }

    @Test
    fun three() {
        runTest(3, Stopwatch()::solve)
    }
}