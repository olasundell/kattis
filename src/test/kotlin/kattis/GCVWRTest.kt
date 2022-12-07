package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class GCVWRTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, GCVWR()::solve)
    }

    @Test
    fun two() {
        runTest(2, GCVWR()::solve)
    }
}