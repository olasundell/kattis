package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class FreeFoodTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FreeFood()::solve)
    }

    @Test
    fun two() {
        runTest(2, FreeFood()::solve)
    }

    @Test
    fun three() {
        runTest(3, FreeFood()::solve)
    }
}