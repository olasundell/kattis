package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class EyeOfSauronTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, EyeOfSauron()::solve)
    }

    @Test
    fun two() {
        runTest(2, EyeOfSauron()::solve)
    }

    @Test
    fun three() {
        runTest(3, EyeOfSauron()::solve)
    }

    @Test
    fun four() {
        runTest(4, EyeOfSauron()::solve)
    }
}