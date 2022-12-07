package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class PeasoupTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Peasoup()::solve)
    }

    @Test
    fun two() {
        runTest(2, Peasoup()::solve)
    }

    @Test
    fun three() {
        runTest(3, Peasoup()::solve)
    }
}