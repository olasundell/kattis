package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class TimeBombTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, TimeBomb()::solve)
    }

    @Test
    fun two() {
        runTest(2, TimeBomb()::solve)
    }

    @Test
    fun three() {
        runTest(3, TimeBomb()::solve)
    }

    @Test
    fun four() {
        runTest(4, TimeBomb()::solve)
    }
}