package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class DrunkVigenereTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, DrunkVigenere()::solve)
    }

    @Test
    fun two() {
        runTest(2, DrunkVigenere()::solve)
    }
}