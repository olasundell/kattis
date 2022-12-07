package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class FYITest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FYI()::solve)
    }

    @Test
    fun two() {
        runTest(2, FYI()::solve)
    }

    @Test
    fun three() {
        runTest(3, FYI()::solve)
    }

    @Test
    fun four() {
        runTest(4, FYI()::solve)
    }
}