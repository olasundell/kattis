package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CPRNummerTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CPRNummer()::solve)
    }

    @Test
    fun two() {
        runTest(2, CPRNummer()::solve)
    }

    @Test
    fun three() {
        runTest(3, CPRNummer()::solve)
    }
}