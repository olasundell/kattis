package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class SimoneTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Simone()::solve)
    }

    @Test
    fun two() {
        runTest(2, Simone()::solve)
    }

    @Test
    fun three() {
        runTest(3, Simone()::solve)
    }

    @Test
    fun four() {
        runTest(4, Simone()::solve)
    }
}