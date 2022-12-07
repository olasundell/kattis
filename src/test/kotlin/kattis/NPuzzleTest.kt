package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class NPuzzleTest : AbstractKotlinTest() {
    @Test
    fun zero() {
        runTest(0, NPuzzle()::solve)
    }

    @Test
    fun one() {
        runTest(1, NPuzzle()::solve)
    }
}