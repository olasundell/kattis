package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class OfugsnuidTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Ofugsnuid()::solve)
    }
    @Test
    fun two() {
        runTest(2, Ofugsnuid()::solve)
    }
}