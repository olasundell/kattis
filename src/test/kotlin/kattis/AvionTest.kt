package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class AvionTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Avion()::solve)
    }

    @Test
    fun two() {
        runTest(2, Avion()::solve)
    }

    @Test
    fun three() {
        runTest(3, Avion()::solve)
    }
}