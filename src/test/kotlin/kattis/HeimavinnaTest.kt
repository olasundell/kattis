package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class HeimavinnaTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Heimavinna()::solve)
    }

    @Test
    fun two() {
        runTest(2, Heimavinna()::solve)
    }

    @Test
    fun three() {
        runTest(3, Heimavinna()::solve)
    }
}