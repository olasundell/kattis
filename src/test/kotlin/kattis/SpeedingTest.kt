package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class SpeedingTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Speeding()::solve)
    }

    @Test
    fun two() {
        runTest(2, Speeding()::solve)
    }
}